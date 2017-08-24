package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;

import java.util.List;

public interface SubCategoryService {

    SubCategoryVo getSubCategoryById(Long id);

    List<SubCategoryVo> getAllSubCategoriesByCategoryId(Long id);
}
