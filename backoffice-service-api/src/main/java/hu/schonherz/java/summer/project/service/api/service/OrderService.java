package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.OrderVo;

import java.util.List;

public interface OrderService {

    void saveOrder(OrderVo orderVo);

    OrderVo getOrderById(long id);

    List<OrderVo> getAllOrders();

    OrderVo getOrderByPrice(Double price);
}
