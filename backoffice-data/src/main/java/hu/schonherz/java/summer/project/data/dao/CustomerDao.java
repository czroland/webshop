package hu.schonherz.java.summer.project.data.dao;


import hu.schonherz.java.summer.project.data.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerDao extends JpaRepository<CustomerEntity, Long> {

    CustomerEntity findByUsername(String username);

    CustomerEntity findByEmail(String email);

    //List<CustomerEntity> findByCompanyName(String companyName);

    CustomerEntity findById(Long id);

    List<CustomerEntity> findAll();
}