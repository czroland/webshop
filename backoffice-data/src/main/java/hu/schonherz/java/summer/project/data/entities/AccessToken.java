package hu.schonherz.java.summer.project.data.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "tokens")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessToken extends BaseEntity {

    @Column(nullable = false)
    private String token;

    @ManyToOne
    private CustomerEntity customer;

    @Column
    private Date expiry;

    public boolean isExpired() {
        if (null == this.expiry) {
            return false;
        }

        return this.expiry.getTime() > System.currentTimeMillis();
    }

    public AccessToken(CustomerEntity customer, String token) {
        this.customer = customer;
        this.token = token;
    }
}
