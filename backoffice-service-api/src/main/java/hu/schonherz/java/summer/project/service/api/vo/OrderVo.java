package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
public class OrderVo extends BaseVo {

    private Date sendDate = new Date();

    private Double price;

    @JsonIgnore
    private CustomerVo customer;

    private List<ProductVo> products;

    public OrderVo() {
        products = new ArrayList<>();
    }

    private boolean isSuccess;

    private Date successDate;

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public CustomerVo getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerVo customer) {
        this.customer = customer;
    }

    public List<ProductVo> getProducts() {
        return products;
    }

    public void setProducts(List<ProductVo> products) {
        this.products = products;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Date getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(Date successDate) {
        this.successDate = successDate;
    }
}
