package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MBLogin {

    @Autowired
    private AgentService agentService;

}
