package hu.schonherz.java.summer.project.service.impl.user;

import hu.schonherz.java.summer.project.data.entities.UserEntity;
import hu.schonherz.java.summer.project.data.dao.UserDao;
import hu.schonherz.java.summer.project.service.api.service.user.UserServiceLocal;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import hu.schonherz.java.summer.project.service.mapper.UserEntityVoMapper;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceBean implements UserServiceLocal {

    private static final String DOES_NOT_EXIST = " does not exist!";

    @Autowired
    private UserDao userDao;

    @Override
    public UserVo findByUsername(final String username) {
        return UserEntityVoMapper.toVo(userDao.findByUsername(username));
    }

    @Override
    public UserVo findByEmail(final String email) {
        return UserEntityVoMapper.toVo(userDao.findByEmail(email));
    }

    @Override
    public Set<UserVo> findByCompanyName(final String companyName) {
        return null; //UserEntityVoMapper.toVo(userDao.findByCompanyName(companyName));
    }

    @Override
    public UserVo registrationUser(final UserVo userVo) {
        UserEntity user = UserEntityVoMapper.toEntity(userVo);
        user = userDao.save(user);
        if (user == null) {
            log.warn("Failed to persist user " + userVo.getUsername());
        }

        return UserEntityVoMapper.toVo(user);
    }

    public void saveAll(final Collection<UserVo> vos) {
        userDao.save(UserEntityVoMapper.toEntity(vos));
    }

    @Override
    public List<UserVo> findAll() {
        List<UserEntity> allEntities = userDao.findAll();
        return allEntities.stream().map(entity -> UserEntityVoMapper.toVo(entity)).collect(Collectors.toList());
    }

    public void delete(final Long id) {
        userDao.delete(id);
    }

    @Override
    public UserVo findById(final Long id) {
        return UserEntityVoMapper.toVo(findOne(id));
    }

    private UserEntity findOne(final Long id) {
        UserEntity userEntity = userDao.findOne(id);
        if (userEntity == null) {
            log.warn("User with id " + id + DOES_NOT_EXIST);
        }

        return userEntity;
    }

}
