package hu.schonherz.java.summer.project.service.api.vo;


import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;


public class BaseVo implements Serializable {

    private static final long serialVersionUID = -6214960303946037900L;

    private Long id;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}