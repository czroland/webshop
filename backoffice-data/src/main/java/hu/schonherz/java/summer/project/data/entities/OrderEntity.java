package hu.schonherz.java.summer.project.data.entities;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<ProductEntity> products;

    @Column(nullable = false)
    private boolean isSuccess;

    @Column
    private Date successDate;
}