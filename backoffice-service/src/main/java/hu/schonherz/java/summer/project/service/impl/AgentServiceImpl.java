package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.AgentDao;
import hu.schonherz.java.summer.project.data.dao.UserDao;
import hu.schonherz.java.summer.project.data.entities.AgentEntity;
import hu.schonherz.java.summer.project.data.entities.RoleEntity;
import hu.schonherz.java.summer.project.data.entities.UserEntity;
import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
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
        AgentEntity agent = agentRepository.findById(id);
        if (agent != null) {
            return map(agent, AgentVo.class);
        }
        return null;
    }

    @Override
    public AgentVo getAgentByName(String name) {
        UserEntity user = userRepository.findByUsername(name);
        if (user != null) {
            AgentEntity agent = agentRepository.findByUserId(user.getId());
            if (agent != null) {
                return map(agent, AgentVo.class);
            }
        }

        return null;
    }

    @Override
    public AgentVo getAgentByUserId(Long id) {
        AgentEntity agent = agentRepository.findByUserId(id);
        if (agent != null) {
            return map(agent, AgentVo.class);
        }
        return null;
    }

    @Override
    public void addRoleToAgent(String name, RoleVo roleVo) {
        boolean contains = false;

        for (RoleEntity role : agentRepository
            .findByUserId(userRepository
                .findByUsername(name).getId())
            .getRoles()) {
            contains = role.getName().equals(roleVo.getName());
            if (contains) break;
        }

        if (!contains) {
            agentRepository
                .findByUserId(userRepository.findByUsername(name).getId())
                .getRoles()
                .add(map(roleVo, RoleEntity.class));
        }
    }

    @Override
    public void removeRoleFromAgent(String name, RoleVo roleVo) {
        List<RoleEntity> newRoles = agentRepository
            .findByUserId(userRepository.findByUsername(name).getId())
            .getRoles()
            .stream()
            .filter(role -> !(role.getName().equals(roleVo.getName())))
            .collect(Collectors.toList());

        agentRepository
            .findByUserId(userRepository.findByUsername(name).getId())
            .setRoles(newRoles);
    }
}
