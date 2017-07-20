package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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
