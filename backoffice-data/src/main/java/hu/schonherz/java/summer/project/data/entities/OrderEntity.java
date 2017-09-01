package hu.schonherz.java.summer.project.data.entities;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

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

    @Temporal(TemporalType.TIMESTAMP)
    private Date sendDate;

    @Column(nullable = false)
    private Double price;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ProductEntity> products;

    @Column(nullable=false)
    private boolean isSuccess;

    @Column
    private Date successDate;
}