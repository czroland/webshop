package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.service.user.UserService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Component
@Scope("request")
@Data
public class MBLogin {

    @Autowired
    private AgentService agentService;

    @Autowired
    private UserService userService;

    private String username;

    private String password;

    public void login() throws ServletException, IOException {
        AgentVo agent = agentService.getAgentByName(username);
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (agent == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Login error", "Login failed"));
            return;
        }

        ExternalContext externalContext = facesContext.getExternalContext();
        RequestDispatcher dispatcher = ((ServletRequest) externalContext.getRequest())
            .getRequestDispatcher("/login");
        dispatcher.forward((ServletRequest) externalContext.getRequest(),
            (ServletResponse) externalContext.getResponse());
        facesContext.responseComplete();
    }
}
