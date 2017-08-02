package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Scope("view")
@Data
public class MBAgent implements Serializable {

    private static final long serialVersionUID = -1559952931899511300L;

    private AgentVo agent;

    @PostConstruct
    public void init() {
        agent = new AgentVo();
        agent.setUser(new UserVo());
    }

}
