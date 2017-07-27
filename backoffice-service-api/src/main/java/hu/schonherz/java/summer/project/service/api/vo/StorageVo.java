package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class StorageVo extends BaseVo {

    private String name;
    private UserVo storeKeeper;
    private AddressVo address;
    private Integer avgShippingTimeInDays;
}
