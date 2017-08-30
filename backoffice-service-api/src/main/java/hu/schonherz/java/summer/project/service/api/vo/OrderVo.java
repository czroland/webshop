package hu.schonherz.java.summer.project.service.api.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderVo extends BaseVo {

    private Date date;

    private Double price;

    private CustomerVo customer;

    private List<ProductVo> products;

    public OrderVo() {
        products = new ArrayList<>();
    }

    private boolean isSuccess;

    private Date successDate;
}

