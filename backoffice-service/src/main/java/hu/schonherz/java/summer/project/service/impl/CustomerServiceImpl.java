package hu.schonherz.java.summer.project.service.impl;

import hu.schonherz.java.summer.project.data.dao.AccessTokenDao;
import hu.schonherz.java.summer.project.data.dao.CustomerDao;
import hu.schonherz.java.summer.project.data.dao.UserDao;
import hu.schonherz.java.summer.project.data.entities.AccessToken;
import hu.schonherz.java.summer.project.data.entities.CustomerEntity;
import hu.schonherz.java.summer.project.data.entities.UserEntity;
import hu.schonherz.java.summer.project.service.api.service.CustomerService;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;
import hu.schonherz.java.summer.project.service.mapper.AbstractEntityVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerServiceImpl extends AbstractEntityVoMapper implements CustomerService {

    @Autowired
    private CustomerDao customerRepository;

    @Autowired
    private AccessTokenDao accessTokenRepository;

    @Autowired
    private UserDao userRepository;

    @Override
    public void saveCustomer(CustomerVo customer) {
        customer.setRole("ROLE_USER");
        customerRepository.save(map(customer, CustomerEntity.class));
    }

    @Override
    public CustomerVo getCustomerByName(String name) {
        UserEntity user = userRepository.findByUsername(name);
        if (user != null) {
            CustomerEntity customer = customerRepository.findByUserId(user.getId());
            if (customer != null) {
                return map(customer, CustomerVo.class);
            }
        }

        return null;
    }

    @Override
    public CustomerVo getCustomerByAccessToken(String token) {
        AccessToken accessToken = accessTokenRepository.findByToken(token);

        if (accessToken == null) {
            return null;
        }
        if (accessToken.isExpired()) {
            accessTokenRepository.delete(accessToken);
            return null;
        }
        return map(accessToken.getCustomer(), CustomerVo.class);
    }

    @Override
    public CustomerVo getCustomerById(Long id) {
        return map(customerRepository.findById(id), CustomerVo.class);
    }
}
