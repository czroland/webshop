package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.StorageVo;

import java.util.List;

public interface StorageService {

    void saveStorage(StorageVo storage);

    StorageVo getStorageById(Long id);

    List<StorageVo> getAllStorages();
}
