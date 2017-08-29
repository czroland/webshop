package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.OrderDao;
import hu.schonherz.java.summer.project.data.entities.OrderEntity;
import hu.schonherz.java.summer.project.service.api.service.OrderService;
import hu.schonherz.java.summer.project.service.api.vo.OrderVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl extends AbstractEntityVoMapper implements OrderService {

    @Autowired
    private OrderDao orderRepository;

    @Override
    public void saveOrder(OrderVo order) {
        orderRepository.save(map(order, OrderEntity.class));
    }

    @Override
    public OrderVo getOrderById(long id) {
        OrderEntity order = null;
        order = orderRepository.findById(id);
        if (order != null) {
            return map(order, OrderVo.class);
        }
        return null;
    }

    @Override
    public List<OrderVo> getAllOrders() {
        return map(orderRepository.findAll(), OrderVo.class);
    }
}
