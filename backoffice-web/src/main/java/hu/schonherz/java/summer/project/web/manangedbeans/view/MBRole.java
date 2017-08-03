package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.service.RoleService;
import hu.schonherz.java.summer.project.service.api.vo.RoleVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("view")
@Data
public class MBRole implements Serializable {

    private static final long serialVersionUID = -6030931546658654317L;

    @Autowired
    private RoleService roleService;

    private List<RoleVo> roles = new ArrayList<>();
    private String agentRole;

    @PostConstruct
    public void init(){
        roles = roleService.getAllRoles();
    }
}
