package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class ProductImageVo extends BaseVo {

    private String name;

    private String root;
}
