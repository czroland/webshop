package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class AgentVo extends BaseVo {

    private UserVo user;

    private List<RoleVo> roles;

    public AgentVo() {
        roles = new ArrayList<>();
    }
}
