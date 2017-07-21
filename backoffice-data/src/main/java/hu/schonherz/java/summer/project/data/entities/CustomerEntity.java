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
@Builder
public class CustomerEntity extends UserEntity{

    @Column(nullable = false)
    private AddressEntity billingAddress;

    @Column(nullable = false)
    private AddressEntity deliveryAddress

}
