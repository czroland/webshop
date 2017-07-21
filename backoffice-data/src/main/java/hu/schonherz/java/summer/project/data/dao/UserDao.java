package hu.schonherz.java.summer.project.data.dao;


import hu.schonherz.java.summer.project.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    UserEntity findByEmail(String email);

    List<UserEntity> findByCompanyName(String companyName);

    UserEntity findById(Long id);

    List<UserEntity> findAll();

}
