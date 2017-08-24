package hu.schonherz.java.summer.project.data.dao;

import hu.schonherz.java.summer.project.data.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface CategoryDao extends JpaRepository<CategoryEntity, Long> {
}
