package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ProductVo extends BaseVo {

    private String name;

    private String description;

    private String number;

    private ProductImageVo image;

    private CategoryVo category;

    private SubCategoryVo subCategory;
}
