package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.service.RoleService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBAgent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("request")
@Data
public class MBRoleManagement {

    @Autowired
    private AgentService agentService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MBAgent agent;

    public void addRole(List<AgentVo> agents, String role) {
        RoleVo roleVo = roleService.getRoleByName(role);

        for (AgentVo agentVo : agents) {
            agentService.addRoleToAgent(agentVo.getUser().getUsername(), roleVo);
        }
        agent.init();
    }

    public void removeRole(List<AgentVo> agents, String role) {
        RoleVo roleVo = roleService.getRoleByName(role);

        for (AgentVo agentVo : agents) {
            agentService.removeRoleFromAgent(agentVo.getUser().getUsername(), roleVo);
        }
        agent.init();
    }
}
