package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.ProductVo;

import java.util.List;

public interface ProductService {

    void saveProduct(ProductVo productVo);

    ProductVo getProductByName(String name);

    ProductVo getProductById(long id);

    ProductVo getProductByNumber(String number);

    List<ProductVo> getAllProducts();
}
