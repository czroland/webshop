package hu.schonherz.java.summer.project.service.api.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CartVo extends BaseVo {

    private UserVo userVo;
    private List<ProductVo> productVos;
}
