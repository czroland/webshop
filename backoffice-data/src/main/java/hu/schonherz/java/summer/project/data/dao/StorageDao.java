package hu.schonherz.java.summer.project.data.dao;



import hu.schonherz.java.summer.project.data.entities.StorageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageDao extends JpaRepository<StorageEntity, Long> {


    StorageEntity findById(Long id);

    List<StorageEntity> findAll();
}
