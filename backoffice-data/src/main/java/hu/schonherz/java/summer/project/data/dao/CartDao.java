package hu.schonherz.java.summer.project.data.dao;


import hu.schonherz.java.summer.project.data.entities.CartEntity;
import hu.schonherz.java.summer.project.data.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDao extends JpaRepository<CartEntity, Long> {

    CartEntity findById(Long id);
    List<CartEntity> findAll();


}
