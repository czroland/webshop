package hu.schonherz.java.summer.project.integration.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressChange {

    private String zipCode;

    private String city;

    private String street;

    private String number;
}
