package hu.schonherz.java.summer.project.service.api.service;


import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerVo customer);

    CustomerVo getCustomerByName(String name);

    CustomerVo getCustomerByAccessToken(String token);

    CustomerVo getCustomerById(Long id);

    List<CustomerVo> getAllCustomers();

    void editCustomer(Long id, String name, String fullName, String phone, String email);

}
