package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "VARCHAR(40)")
    private String fullName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String phoneNumber;

    @Column(nullable = false)
    private String billingAddress;

    @Column(nullable = false)
    private String deliveryAddress;

    public CustomerEntity(String username) {
        this.username = username;
    }

}
