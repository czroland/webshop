package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity extends BaseEntity {

    @Column(nullable = false)
    private Date date;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProductEntity> products;
}
