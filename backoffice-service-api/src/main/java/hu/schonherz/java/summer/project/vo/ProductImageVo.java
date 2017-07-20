package hu.schonherz.java.summer.project.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductImageVo implements Serializable {

    private static final long serialVersionUID = 2109271240752611109L;

    private Long id;

    private String name;

    private String root;

    private ProductVo product;
}
