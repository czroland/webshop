package hu.schonherz.java.summer.project.data.dao;


import hu.schonherz.java.summer.project.data.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends JpaRepository<AddressEntity, Long> {

    AddressEntity findById(Long id);
    List<AddressEntity> findAll();
}
