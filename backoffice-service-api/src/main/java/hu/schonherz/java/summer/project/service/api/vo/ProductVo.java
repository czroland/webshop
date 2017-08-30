package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductVo extends BaseVo {

    private String name;

    private String description;

    private Double price;

    private String number;

    private List<ProductImageVo> images;

    private CategoryVo category;

    private SubCategoryVo subCategory;

    public ProductVo() {
        images = new ArrayList<>();
    }
}
