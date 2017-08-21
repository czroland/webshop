package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity extends BaseEntity {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private AddressEntity billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_address_id")
    private AddressEntity deliveryAddress;

    private String role;
}
