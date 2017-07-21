package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductVo extends BaseVo{


    private String name;

    private String description;

    private String number;

    private ProductImageVo image;
}
