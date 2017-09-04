package hu.schonherz.java.summer.project.service.api.vo;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CustomerVo extends BaseVo {

    private UserVo user;

    private AddressVo billingAddress;

    private AddressVo deliveryAddress;

    private CartVo cart;

    private String role;

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public AddressVo getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressVo billingAddress) {
        this.billingAddress = billingAddress;
    }

    public AddressVo getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressVo deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @JsonIgnore
    public CartVo getCart() {
        return cart;
    }

    public void setCart(CartVo cart) {
        this.cart = cart;
    }

    @JsonIgnore
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}