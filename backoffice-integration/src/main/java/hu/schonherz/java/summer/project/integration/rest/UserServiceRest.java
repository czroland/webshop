package hu.schonherz.java.summer.project.integration.rest;

import com.sun.jersey.api.NotFoundException;
import hu.schonherz.java.summer.project.integration.Vo.CustomerChange;
import hu.schonherz.java.summer.project.integration.Vo.LoginVo;
import hu.schonherz.java.summer.project.service.api.service.*;
import hu.schonherz.java.summer.project.service.api.service.user.UserService;
import hu.schonherz.java.summer.project.service.api.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/user")
public class UserServiceRest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Path("authenticate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AccessTokenVo authenticate(LoginVo loginVo) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(loginVo.getUsername(), loginVo.getPassword());
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return accessTokenService.createAccessToken((customerService.getCustomerByName(loginVo.getUsername())));
    }

    private CustomerVo getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomerVo customer = (CustomerVo) principal;

        if (!(principal instanceof CustomerVo)) {

            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        return customer;
    }

    @Path("add-user")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(CustomerVo customer, @Context UriInfo uriInfo) {

        for (UserVo c : userService.findAll()) {
            if (c.getUsername().equals(customer.getUser().getUsername())) {
                return Response.status(Response.Status.NOT_ACCEPTABLE.getStatusCode())
                    .header(
                        "Location",
                        String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                            customer.getId())).build();
            }
        }

        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        customer.getUser()
            .setPassword(bCryptPasswordEncoder.encode(customer
                .getUser()
                .getPassword()));
        customer.setCart(new CartVo());
        customerService.saveCustomer(customer);

        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    customer.getId())).build();
    }

    @Path("edit-user")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editUser(CustomerChange customer, @Context UriInfo uriInfo) {
        customerService.editCustomer(getUser().getId(), customer.getUserName(), customer.getFullName(), customer.getPhone(), customer.getEmail());
    }

    @Path("orders")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderVo> getOrders() {
        if (orderService.getOrdersByCustomerId(getUser().getId()).isEmpty()) {
            throw new NotFoundException("No such orders.");
        }

        return orderService.getOrdersByCustomerId(getUser().getId());
    }

    @Path("cart")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CartVo getCart() {

        return getUser().getCart();
    }

    @Path("place-order")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(@Context UriInfo uriInfo) {

        OrderVo order = new OrderVo();
        order.setCustomer(getUser());
        order.setProducts(getUser().getCart().getProducts());
        orderService.saveOrder(order);
        getUser().getCart().getProducts().clear();
        customerService.saveCustomer(getUser());
        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    order.getId())).build();
    }

    @Path("add-product")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductToCart(ProductVo productVo, @Context UriInfo uriInfo) {
        getUser().getCart().getProducts().add(productService.getProductByNumber(productVo.getNumber()));
        customerService.saveCustomer(getUser());

        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    productVo.getNumber())).build();
    }

    @Path("remove-product")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeProductFromCart(ProductVo productVo, @Context UriInfo uriInfo) {

        getUser().getCart().getProducts().remove(productService.getProductByNumber(productVo.getNumber()));
        customerService.saveCustomer(getUser());
        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    productVo.getNumber())).build();
    }
}