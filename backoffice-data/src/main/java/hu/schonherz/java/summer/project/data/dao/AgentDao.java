package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentDao extends JpaRepository<AgentEntity, Long> {

    AgentEntity findById(Long id);

    AgentEntity findByUserId(Long id);
}
