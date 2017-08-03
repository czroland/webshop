package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface RoleDao extends JpaRepository<RoleEntity, Long> {

    RoleEntity findById(Long id);

    RoleEntity findByName(String name);

    @Query("SELECT r FROM AgentEntity u JOIN u.roles r WHERE u.id = ?1")
    List<RoleEntity> findRolesByAgentId(Long userId);
}