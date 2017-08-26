package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Basic
    private String description;

    @Column(nullable = false, unique = true)
    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private ProductImageEntity image;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToOne
    @JoinColumn(name = "sub_category_id")
    private SubCategoryEntity subCategory;
}
