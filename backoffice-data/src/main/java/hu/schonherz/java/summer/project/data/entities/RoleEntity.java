package hu.schonherz.java.summer.project.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
@EqualsAndHashCode(callSuper = true)
public class RoleEntity extends BaseEntity {

    @Basic
    @Column(nullable = false)
    private String name;
}
