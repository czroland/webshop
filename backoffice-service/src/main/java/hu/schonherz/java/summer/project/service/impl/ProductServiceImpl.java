package hu.schonherz.java.summer.project.service.impl;


import hu.schonherz.java.summer.project.data.dao.ProductDao;
import hu.schonherz.java.summer.project.data.entities.ProductEntity;
import hu.schonherz.java.summer.project.service.api.service.ProductService;
import hu.schonherz.java.summer.project.service.api.vo.ProductVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl extends AbstractEntityVoMapper implements ProductService{

    @Autowired
    private ProductDao productRepository;

    @Override
    public void saveProduct(ProductVo product) {
        productRepository.save(map(product, ProductEntity.class));
    }

    @Override
    public ProductVo getProductByName(String name) {
        ProductEntity product = null;
        product = productRepository.findByName(name);
        if (product != null) {
            return map(product, ProductVo.class);
        }
        return null;
    }

    @Override
    public ProductVo getProductById(long id) {
        ProductEntity product = null;
        product = productRepository.findById(id);
        if (product != null) {
            return map(product, ProductVo.class);
        }
        return null;
    }

    @Override
    public ProductVo getProductByNumber(String number) {
        ProductEntity product = null;
        product = productRepository.findByNumber(number);
        if (product != null) {
            return map(product, ProductVo.class);
        }
        return null;
    }
}
