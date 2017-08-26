package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.ProductImageDao;
import hu.schonherz.java.summer.project.data.entities.ProductEntity;
import hu.schonherz.java.summer.project.data.entities.ProductImageEntity;
import hu.schonherz.java.summer.project.service.api.service.ProductImageService;
import hu.schonherz.java.summer.project.service.api.vo.ProductImageVo;
import hu.schonherz.java.summer.project.service.api.vo.ProductVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductImageServiceImpl extends AbstractEntityVoMapper implements ProductImageService {

    @Autowired
    private ProductImageDao productImageRepository;

    @Override
    public ProductImageVo getProductImageById(long id) {

        ProductImageEntity productImage = null;
        productImage = productImageRepository.findById(id);
        if (productImage != null) {
            return map(productImage, ProductImageVo.class);
        }
        return null;
    }

    @Override
    public void saveImage(ProductImageVo imageVo) {
        productImageRepository.save(map(imageVo, ProductImageEntity.class));
    }
}
