package hu.schonherz.java.summer.project.data.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String fullName;
    private String email;
    private String phone;
    private String password;



}
