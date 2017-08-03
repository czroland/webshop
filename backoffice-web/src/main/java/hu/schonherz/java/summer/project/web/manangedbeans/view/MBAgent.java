package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import lombok.Data;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("view")
@Data
public class MBAgent implements Serializable {

    private static final long serialVersionUID = -1559952931899511300L;

    @Autowired
    private AgentService agentService;

    private DualListModel<AgentVo> agents;

    private AgentVo agent;

    @PostConstruct
    @Transactional
    public void init() {
        agent = new AgentVo();
        agent.setUser(new UserVo());

        List<AgentVo> agentSource = new ArrayList<>();
        List<AgentVo> agentTarget = new ArrayList<>();

        agentSource = agentService.getAllAgents();
        agents = new DualListModel<AgentVo>(agentSource, agentTarget);
    }

}
