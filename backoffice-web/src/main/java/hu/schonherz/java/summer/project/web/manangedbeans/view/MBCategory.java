package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.service.CategoryService;
import hu.schonherz.java.summer.project.service.api.service.SubCategoryService;
import hu.schonherz.java.summer.project.service.api.vo.CategoryVo;
import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "categoryBean")
@Scope("view")
@Data
public class MBCategory implements Serializable {

    private static final long serialVersionUID = -1752852770423596933L;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    private List<CategoryVo> categories = new ArrayList<>();
    private List<SubCategoryVo> subCategories = new ArrayList<>();

    private CategoryVo category;
    private SubCategoryVo subCategory;

    @PostConstruct
    public void init() {
        categories = categoryService.getAllCategories();
    }

    public void selectOneMenuListener(AjaxBehaviorEvent event) {
        subCategories = subCategoryService.getAllSubCategoriesByCategoryId(category.getId());
    }
    }
