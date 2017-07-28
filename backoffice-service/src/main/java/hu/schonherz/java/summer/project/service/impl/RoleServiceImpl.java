package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.RoleDao;
import hu.schonherz.java.summer.project.data.entities.RoleEntity;
import hu.schonherz.java.summer.project.service.api.service.RoleService;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractEntityVoMapper implements RoleService {

    @Autowired
    private RoleDao roleRepository;

    @Override

    public RoleVo getRoleById(Long id) {
        RoleEntity role = null;
        role = roleRepository.findById(id);
        if (role != null) {
            return map(role, RoleVo.class);
        }
        return null;
    }

    @Override
    public RoleVo getRoleByName(String name) {
        RoleEntity role = null;
        role = roleRepository.findByName(name);
        if (role != null) {
            return map(role, RoleVo.class);
        }
        return null;
    }

    @Override
    public List<RoleVo> getRolesByAgentId(Long id) {
        return map(roleRepository.findRolesByAgentId(id), RoleVo.class);
    }
}
