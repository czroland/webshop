package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressEntity extends BaseEntity {

    private String zipCode;

    private String city;

    private String street;

    private String number;
}
