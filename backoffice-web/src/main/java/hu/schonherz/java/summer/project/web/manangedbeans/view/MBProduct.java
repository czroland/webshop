package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.vo.ProductVo;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component(value = "productBean")
@Scope("view")
@Data
public class MBProduct implements Serializable {

    private static final long serialVersionUID = -1965507870856339427L;

    private ProductVo product;

    @PostConstruct
    public void init() {
        product = new ProductVo();
    }
}
