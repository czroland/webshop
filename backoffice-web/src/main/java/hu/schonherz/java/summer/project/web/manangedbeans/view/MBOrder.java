package hu.schonherz.java.summer.project.web.manangedbeans.view;


import hu.schonherz.java.summer.project.service.api.service.OrderService;
import hu.schonherz.java.summer.project.service.api.vo.OrderVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

@Component(value = "orderBean")
@Scope("view")
@Data
public class MBOrder implements Serializable {

    private static final long serialVersionUID = -1965507870856339427L;

    @Autowired
    private OrderService orderService;

    private OrderVo order;
    private List<OrderVo> orders;

    @PostConstruct
    public void init() {
        order = new OrderVo();
        orders = orderService.getAllOrders();
    }
}

