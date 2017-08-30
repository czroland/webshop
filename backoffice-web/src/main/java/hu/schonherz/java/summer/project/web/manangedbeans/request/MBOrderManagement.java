package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.OrderService;
import hu.schonherz.java.summer.project.service.api.vo.OrderVo;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBOrder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component(value = "orderMnmtBean")
@Scope("request")
@Data
public class MBOrderManagement {

    @Autowired
    private OrderService orderService;

    @Autowired
    private MBOrder mbOrder;

    public void fulfillOrder(List<OrderVo> orders) {

        for (OrderVo orderVo : orders) {
            if (!orderVo.isSuccess()) {
                orderVo.setSuccess(true);
                orderVo.setSuccessDate(new Date());
                orderService.saveOrder(orderVo);
            }
        }
        mbOrder.init();
    }
}
