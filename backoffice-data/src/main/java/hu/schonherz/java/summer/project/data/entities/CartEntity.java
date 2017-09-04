package hu.schonherz.java.summer.project.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "carts")
public class CartEntity extends BaseEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    private List<ProductEntity> products;

}
