package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerVo extends BaseVo {

    private UserVo user;

    private AddressVo billingAddress;

    private AddressVo deliveryAddress;

    private CartVo cart;

    private String role;

}