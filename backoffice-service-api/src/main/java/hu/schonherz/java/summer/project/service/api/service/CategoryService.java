package hu.schonherz.java.summer.project.service.api.service;

import hu.schonherz.java.summer.project.service.api.vo.CategoryVo;

import java.util.List;


public interface CategoryService {

    List<CategoryVo> getAllCategories();

    CategoryVo getCategoryById(Long id);
}
