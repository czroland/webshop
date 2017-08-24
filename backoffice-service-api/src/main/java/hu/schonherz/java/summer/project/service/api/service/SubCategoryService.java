package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.SubCategoryVo;

import java.util.List;

public interface SubCategoryService {

    List<SubCategoryVo> getAllSubCategoriesByCategoryId(Long id);
}
