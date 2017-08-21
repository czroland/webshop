package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.AccessTokenDao;
import hu.schonherz.java.summer.project.data.entities.AccessToken;
import hu.schonherz.java.summer.project.service.api.service.AccessTokenService;
import hu.schonherz.java.summer.project.service.api.vo.AccessTokenVo;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccessTokenServiceImpl extends AbstractEntityVoMapper implements AccessTokenService {

    @Autowired
    private AccessTokenDao accessTokenDao;

    @Override
    public AccessTokenVo findByToken(String token) {
        AccessToken accessToken = accessTokenDao.findByToken(token);
        return map(accessToken, AccessTokenVo.class);
    }

    @Override
    public void createAccessToken(CustomerVo customer) {
        AccessTokenVo accessToken = new AccessTokenVo(customer, UUID.randomUUID().toString());
        accessTokenDao.save(map(accessToken, AccessToken.class));
    }
}
