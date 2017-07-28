package hu.schonherz.java.summer.project.web.security;


import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.service.api.service.RoleService;
import hu.schonherz.java.summer.project.service.api.vo.AgentVo;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AgentService agentService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        AgentVo agentVo;
        try {
            agentVo = agentService.getAgentByName(username);

            if (agentVo == null) {
                throw new UsernameNotFoundException(username);
            }

            List<RoleVo> roles = roleService.getRolesByAgentId(agentVo.getId());

            List<GrantedAuthority> authorities = buildUserAuthority(roles);

            return buildUserForAuthentication(agentVo, authorities);

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private User buildUserForAuthentication(AgentVo agentVo, List<GrantedAuthority> authorities) {
        return new User(agentVo.getUser().getUsername(), agentVo.getUser().getPassword(), true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<RoleVo> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        for (RoleVo role : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }

}