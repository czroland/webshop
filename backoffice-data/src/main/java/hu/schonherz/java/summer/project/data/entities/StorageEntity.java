package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "storages")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StorageEntity extends BaseEntity {

    private String name;
    private UserEntity storeKeeper;
    private AddressEntity address;
    private Integer avgShippingTimeInDays;
}
