package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo extends BaseVo {


    private String username;

    private String fullName;

    private String email;

    private String phone;
    
    private String password;
}
