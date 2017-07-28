package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.AgentDao;
import hu.schonherz.java.summer.project.data.dao.UserDao;
import hu.schonherz.java.summer.project.data.entities.AgentEntity;
import hu.schonherz.java.summer.project.data.entities.UserEntity;
import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl extends AbstractEntityVoMapper implements AgentService {

    @Autowired
    private AgentDao agentRepository;

    @Autowired
    private UserDao userRepository;

    @Override
    public void saveAgent(AgentVo agent) {
        agentRepository.save(map(agent, AgentEntity.class));
    }

    @Override
    public List<AgentVo> getAllAgents() {
        return map(agentRepository.findAll(), AgentVo.class);
    }

    @Override
    public AgentVo getAgentById(Long id) {
        AgentEntity agent = null;
        agent = agentRepository.findById(id);
        if (agent != null) {
            return map(agent, AgentVo.class);
        }
        return null;
    }

    @Override
    public AgentVo getAgentByName(String name) {
        UserEntity user = null;
        user = userRepository.findByUsername(name);
        AgentEntity agent = null;
        agent = agentRepository.findByUserId(user.getId());
        if (agent != null) {
            return map(agent, AgentVo.class);
        }
        return null;
    }

    @Override
    public AgentVo getAgentByUserId(Long id) {
        AgentEntity agent = null;
        agent = agentRepository.findByUserId(id);
        if (agent != null) {
            return map(agent, AgentVo.class);
        }
        return null;
    }
}
