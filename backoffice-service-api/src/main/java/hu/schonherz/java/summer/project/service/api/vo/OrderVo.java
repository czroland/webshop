package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderVo extends BaseVo {

    private Date sendDate;

    private Double price;

    @JsonIgnore
    private CustomerVo customer;

    private List<ProductVo> products;

    public OrderVo() {
        products = new ArrayList<>();
    }

    private boolean isSuccess;

    private Date successDate;
}
