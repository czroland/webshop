package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.ProductImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageDao extends JpaRepository<ProductImageEntity, Long> {

    ProductImageEntity findById(Long id);
}
