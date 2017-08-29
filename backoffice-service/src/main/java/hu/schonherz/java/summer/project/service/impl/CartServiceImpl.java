package hu.schonherz.java.summer.project.service.impl;


import hu.schonherz.java.summer.project.data.dao.CartDao;
import hu.schonherz.java.summer.project.data.entities.CartEntity;
import hu.schonherz.java.summer.project.service.api.service.CartService;
import hu.schonherz.java.summer.project.service.api.vo.CartVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CartServiceImpl extends AbstractEntityVoMapper implements CartService {

    @Autowired
    private CartDao cartRepository;

    @Override
    public void saveCart(CartVo cartVo) {
        cartRepository.save(map(cartVo, CartEntity.class));

    }

    @Override
    public CartVo getCartById(Long id) {
        return map(cartRepository.findById(id), CartVo.class);
    }

    @Override
    public void removeCart(CartVo cartVo) {

    }
}
