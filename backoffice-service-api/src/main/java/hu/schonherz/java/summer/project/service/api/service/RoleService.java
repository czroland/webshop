package hu.schonherz.java.summer.project.service.api.service;

import hu.schonherz.java.summer.project.service.api.vo.RoleVo;

import java.util.List;

public interface RoleService {

    RoleVo getRoleById(Long id);

    RoleVo getRoleByName(String name);

    List<RoleVo> getRolesByAgentId(Long id);

    List<RoleVo> getAllRoles();
}