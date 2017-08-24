package hu.schonherz.java.summer.project.web.converters;

import hu.schonherz.java.summer.project.service.api.vo.CategoryVo;
import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBCategory;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Component("subCategoryVoConverter")
public class SubCategoryVoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        MBCategory category = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{categoryBean}", MBCategory.class);
        return category.getSubCategoryService().getSubCategoryById(Long.valueOf((s)));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return "";
        }
        if (o instanceof SubCategoryVo) {
            return ((SubCategoryVo) o).getId().toString();
        } else {
            return "";
        }
    }
}
