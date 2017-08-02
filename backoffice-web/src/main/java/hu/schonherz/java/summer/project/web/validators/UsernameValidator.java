package hu.schonherz.java.summer.project.web.validators;


import hu.schonherz.java.summer.project.service.api.service.user.UserService;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@Component
@Scope("request")
@Data
public class UsernameValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {

        String username = o.toString();

        UserVo user = userService.findByUsername(username);

        if (user != null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Username exists already",
                "Username is duplicated" + " \"" + username
                    + "\" " + "is already in use, please choose another one!"));
        }
    }
}
