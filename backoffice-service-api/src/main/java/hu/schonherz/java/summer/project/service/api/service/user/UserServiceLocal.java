package hu.schonherz.java.summer.project.service.api.service.user;

import  hu.schonherz.java.summer.project.service.api.vo.UserVo;

public interface UserServiceLocal extends UserService {

    UserVo registrationUser(UserVo userVo);

}