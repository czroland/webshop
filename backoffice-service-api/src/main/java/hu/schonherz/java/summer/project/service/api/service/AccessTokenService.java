package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.AccessTokenVo;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;

public interface AccessTokenService {

    AccessTokenVo findByToken(String token);

    void createAccessToken(CustomerVo customer);
}
