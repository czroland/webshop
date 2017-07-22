package hu.schonherz.java.summer.project.service.api.service.user;

import java.util.List;

import  hu.schonherz.java.summer.project.service.api.vo.UserVo;
import java.util.Collection;
import java.util.Set;

public interface UserService {

    UserVo findById(Long id);

    UserVo findByUsername(String username);

    UserVo findByEmail(String email);

    List<UserVo> findAll();

}
