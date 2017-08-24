package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.SubCategoryDao;
import hu.schonherz.java.summer.project.service.api.service.SubCategoryService;
import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class SubCategoryServiceImpl extends AbstractEntityVoMapper implements SubCategoryService {

    @Autowired
    private SubCategoryDao subCategoryDao;

    @Override
    public SubCategoryVo getSubCategoryById(Long id) {
        return map(subCategoryDao.findOne(id), SubCategoryVo.class);
    }

    @Override
    public List<SubCategoryVo> getAllSubCategoriesByCategoryId(Long id) {
        return map(subCategoryDao.findByCategoryId(id), SubCategoryVo.class);
    }
}
