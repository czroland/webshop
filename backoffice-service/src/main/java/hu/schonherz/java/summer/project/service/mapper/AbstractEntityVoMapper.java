package hu.schonherz.java.summer.project.service.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.MappingException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEntityVoMapper {

    private static final Mapper MAPPER;

    static {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        MAPPER = dozerBeanMapper;
    }

    private static Mapper getMapper() {
        return MAPPER;
    }

    public static <T, U> List<U> map(List<T> var1, Class<U> var2) throws MappingException {
        List<U> vos = new ArrayList<>(var1.size());
        for (T element : var1) {
            vos.add(getMapper().map(element, var2));
        }
        return vos;
    }

    public static <T> T map(Object var1, Class<T> var2) throws MappingException {
        return getMapper().map(var1, var2);
    }

    public static void map(Object var1, Object var2) throws MappingException {
        getMapper().map(var1, var2);
    }

    public static <T> T map(Object var1, Class<T> var2, String var3) throws MappingException {
        return getMapper().map(var1, var2, var3);
    }

    public static void map(Object var1, Object var2, String var3) throws MappingException {
        getMapper().map(var1, var2, var3);
    }

}