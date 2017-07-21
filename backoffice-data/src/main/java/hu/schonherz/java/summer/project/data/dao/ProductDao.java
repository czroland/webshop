package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

    ProductEntity findById(Long id);

    ProductEntity findByNumber(String number);

    List<ProductEntity> findByName(String name);
}
