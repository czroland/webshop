package hu.schonherz.java.summer.project.data.entities;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "baskets")
public class BasketEntity extends BaseEntity{

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column
    private List<ProductEntity> products;
}
