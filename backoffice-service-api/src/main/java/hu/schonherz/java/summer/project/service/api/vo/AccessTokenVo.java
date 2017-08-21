package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessTokenVo extends BaseVo {

    private String token;

    private CustomerVo customer;

    private Date expiry;

    public boolean isExpired() {
        if (null == this.expiry) {
            return false;
        }

        return this.expiry.getTime() > System.currentTimeMillis();
    }

    public AccessTokenVo(CustomerVo customer, String token) {
        this.customer = customer;
        this.token = token;
    }
}
