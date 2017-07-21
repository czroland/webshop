package hu.schonherz.java.summer.project.service.mapper;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.java.summer.project.data.entities.UserEntity;
import hu.schonherz.java.summer.project.service.api.vo.UserVo;
import java.util.Arrays;

public final class UserEntityVoMapper {

    private static final Mapper MAPPER;

    static {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        MAPPER = dozerBeanMapper;
    }

    private UserEntityVoMapper() {
    }

    public static UserVo toVo(final UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }

        return MAPPER.map(userEntity, UserVo.class);
    }

    public static UserEntity toEntity(final UserVo userVo) {
        if (userVo == null) {
            return null;
        }

        return MAPPER.map(userVo, UserEntity.class);
    }

    public static Set<UserVo> toVo(final Collection<UserEntity> entities) {
        if (entities == null) {
            return null;
        }

        if (entities.isEmpty()) {
            return new HashSet<>();
        }

        return entities.stream()
                .map(entity -> toVo(entity))
                .collect(Collectors.toSet());
    }

    public static Set<UserEntity> toEntity(final Collection<UserVo> vos) {
        if (vos == null) {
            return null;
        }

        if (vos.isEmpty()) {
            return new HashSet<>();
        }

        return vos.stream()
                .map(vo -> toEntity(vo))
                .collect(Collectors.toSet());
    }
}
