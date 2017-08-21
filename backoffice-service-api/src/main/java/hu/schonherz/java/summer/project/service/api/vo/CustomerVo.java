package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class CustomerVo extends BaseVo {

    private UserVo user;

    private AddressVo billingAddress;

    private AddressVo deliveryAddress;

    private String role;
}
