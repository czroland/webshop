package hu.schonherz.java.summer.project.integration.rest;

import com.sun.jersey.api.NotFoundException;
import hu.schonherz.java.summer.project.service.api.service.CategoryService;
import hu.schonherz.java.summer.project.service.api.service.SubCategoryService;
import hu.schonherz.java.summer.project.service.api.vo.CategoryVo;
import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Path("/categories")
public class CategoryRestService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SubCategoryService subCategoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryVo> getCategories() {
        return categoryService.getAllCategories();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SubCategoryVo> getSubcategoriesByCategoryId(@PathParam("id") Long id) {
        if(subCategoryService.getAllSubCategoriesByCategoryId(id).isEmpty()){
            throw new NotFoundException("No such subcategories.");
        }
        return subCategoryService.getAllSubCategoriesByCategoryId(id);
    }

}
