package hu.schonherz.java.summer.project.integration.rest;

import hu.schonherz.java.summer.project.service.api.service.AccessTokenService;
import hu.schonherz.java.summer.project.service.api.service.CustomerService;
import hu.schonherz.java.summer.project.service.api.vo.AccessTokenVo;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import hu.schonherz.java.summer.project.service.impl.user.UserServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("/user")
public class UserServiceRest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authManager;

    @Path("authenticate")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public AccessTokenVo authenticate(@FormParam("username") String username, @FormParam("password") String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = this.authManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        return accessTokenService.createAccessToken((customerService.getCustomerByName(username)));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerVo getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (!(principal instanceof UserDetails)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
        UserDetails userDetails = (UserDetails) principal;

        return customerService.getCustomerByName(userDetails.getUsername());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(CustomerVo customer, @Context UriInfo uriInfo) {

        customerService.saveCustomer(customer);

        return Response.status(Response.Status.CREATED.getStatusCode())
            .header(
                "Location",
                String.format("%s/%s", uriInfo.getAbsolutePath().toString(),
                    customer.getId())).build();
    }
}
