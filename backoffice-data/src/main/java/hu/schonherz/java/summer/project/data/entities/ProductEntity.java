package hu.schonherz.java.summer.project.data.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Basic
    private String description;

    @Column(nullable = false)
    private String number;

    @OneToOne
    @JoinColumn(name = "image_id")
    private ProductImageEntity image;

}
