package hu.schonherz.java.summer.project.integration.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerChange {
    private String fullName;
    private String userName;
    private String email;
    private String phone;
}
