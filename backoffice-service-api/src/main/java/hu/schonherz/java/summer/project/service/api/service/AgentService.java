package hu.schonherz.java.summer.project.service.api.service;

import hu.schonherz.java.summer.project.service.api.vo.AgentVo;

import java.util.List;


public interface AgentService {

    void saveAgent(AgentVo agent);

    List<AgentVo> getAllAgents();

    AgentVo getAgentById(Long id);

    AgentVo getAgentByName(String name);

    AgentVo getAgentByUserId(Long id);
}
