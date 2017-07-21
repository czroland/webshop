package hu.schonherz.java.summer.project.vo;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImageVo extends BaseVo {



    private String name;

    private String root;

    private ProductVo product;
}
