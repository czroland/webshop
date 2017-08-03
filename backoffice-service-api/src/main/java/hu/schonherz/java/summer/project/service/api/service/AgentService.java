package hu.schonherz.java.summer.project.service.api.service;

import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;

import java.util.List;


public interface AgentService {

    void saveAgent(AgentVo agent);

    List<AgentVo> getAllAgents();

    AgentVo getAgentById(Long id);

    AgentVo getAgentByName(String name);

    AgentVo getAgentByUserId(Long id);

    void addRoleToAgent(String name, RoleVo roleVo);

    void removeRoleFromAgent(String name, RoleVo roleVo);
}
