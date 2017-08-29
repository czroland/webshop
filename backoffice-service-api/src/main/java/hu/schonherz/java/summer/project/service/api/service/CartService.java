package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.CartVo;

public interface CartService {

    void saveCart(CartVo cartVo);
    CartVo getCartById(Long id);
    void removeCart(CartVo cartVo);

}
