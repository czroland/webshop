package hu.schonherz.java.summer.project.web.manangedbeans.view;

import hu.schonherz.java.summer.project.service.api.service.CustomerService;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component(value = "customerBean")
@Scope("view")
@Data
public class MBCustomer implements Serializable {

    private static final long serialVersionUID = -1092840431598398913L;

    @Autowired
    private CustomerService customerService;

    private List<CustomerVo> customers = new ArrayList<>();

    @PostConstruct
    public void init(){
        customers=customerService.getAllCustomers();
    }
}
