package hu.schonherz.java.summer.project.service.impl;


import hu.schonherz.java.summer.project.data.dao.StorageDao;
import hu.schonherz.java.summer.project.data.entities.StorageEntity;
import hu.schonherz.java.summer.project.service.api.service.StorageService;
import hu.schonherz.java.summer.project.service.api.vo.StorageVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StorageServiceImpl extends AbstractEntityVoMapper implements StorageService {

    @Autowired
    private StorageDao storageRepository;

    @Override
    public void saveStorage(StorageVo storage) {
        storageRepository.save(map(storage, StorageEntity.class));
    }

    @Override
    public StorageVo getStorageById(Long id) {
        StorageEntity storage = null;
        storage = storageRepository.findById(id);
        if (storage != null) {
            return map(storage, StorageVo.class);
        }
        return null;
    }

    @Override
    public List<StorageVo> getAllStorages() {
        return map(storageRepository.findAll(), StorageVo.class);
    }
}
