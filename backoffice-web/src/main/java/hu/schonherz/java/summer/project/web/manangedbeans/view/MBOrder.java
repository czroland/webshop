package hu.schonherz.java.summer.project.web.manangedbeans.view;


import hu.schonherz.java.summer.project.service.api.service.OrderService;
import hu.schonherz.java.summer.project.service.api.vo.OrderVo;
import lombok.Data;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "orderBean")
@Scope("view")
@Data
public class MBOrder implements Serializable {

    private static final long serialVersionUID = -1965507870856339427L;

    @Autowired
    private OrderService orderService;

    private DualListModel<OrderVo> orders;


    @PostConstruct
    public void init() {
        List<OrderVo> orderSource = new ArrayList<>();
        List<OrderVo> orderTarget = new ArrayList<>();

        orderSource = orderService.getAllOrders();
        orders = new DualListModel<OrderVo>(orderSource, orderTarget);
    }
}

