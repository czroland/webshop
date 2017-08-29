package hu.schonherz.java.summer.project.service.impl;


import hu.schonherz.java.summer.project.data.dao.CategoryDao;
import hu.schonherz.java.summer.project.data.entities.CategoryEntity;
import hu.schonherz.java.summer.project.service.api.service.CategoryService;
import hu.schonherz.java.summer.project.service.api.vo.CategoryVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl extends AbstractEntityVoMapper implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryVo> getAllCategories() {
        return map(categoryDao.findAll(), CategoryVo.class);
    }

    @Override
    public CategoryVo getCategoryById(Long id) {
        return map(categoryDao.findOne(id), CategoryVo.class);
    }

    @Override
    public void addCategory(CategoryVo categoryVo) {
        categoryDao.save(map(categoryVo, CategoryEntity.class));
    }
}
