package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<OrderEntity, Long> {

    OrderEntity findById(Long id);

    List<OrderEntity> findAll();

    OrderEntity findByPrice(Double price);
}
