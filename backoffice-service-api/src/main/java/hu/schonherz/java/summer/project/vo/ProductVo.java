package hu.schonherz.java.summer.project.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = -638962998787255001L;

    private Long id;

    private String name;

    private String description;

    private String number;

    private ProductImageVo image;
}
