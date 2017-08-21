package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;

public interface CustomerService {

    void saveCustomer(CustomerVo customer);

    CustomerVo getCustomerByName(String name);

    CustomerVo getCustomerbyAccessToken(String token);
}
