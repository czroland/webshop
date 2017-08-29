package hu.schonherz.java.summer.project.integration.rest;

import hu.schonherz.java.summer.project.service.api.service.ProductService;
import hu.schonherz.java.summer.project.service.api.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/products")
public class ProductServiceRest {

    @Autowired
    private ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductVo> getProducts() {
        return productService.getAllProducts();
    }
}
