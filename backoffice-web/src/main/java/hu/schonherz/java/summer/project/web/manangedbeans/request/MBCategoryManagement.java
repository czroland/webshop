package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.CategoryService;
import hu.schonherz.java.summer.project.service.api.service.SubCategoryService;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBCategory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "categoryMnmtBean")
@Scope("request")
@Data
public class MBCategoryManagement {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private MBCategory mbCategory;

    public void doCreate() {
        mbCategory.getSubCategoryC().setCategory(mbCategory.getCategory());
        subCategoryService.addSubCategory(mbCategory.getSubCategoryC());
    }

    public void doCreateCategory() {
        categoryService.addCategory(mbCategory.getCategoryC());
        mbCategory.init();
    }
}
