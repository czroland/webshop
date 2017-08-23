package hu.schonherz.java.summer.project.integration;


import hu.schonherz.java.summer.project.service.api.service.CustomerService;
import hu.schonherz.java.summer.project.service.api.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
@Transactional(propagation = Propagation.REQUIRED)

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        CustomerVo customerVo;
        try {
            customerVo = customerService.getCustomerByName(username);
            if (customerVo == null) {

                throw new UsernameNotFoundException(username);
            }
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(customerVo.getRole()));

            return buildUserForAuthentication(customerVo, authorities);

        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }

    private User buildUserForAuthentication(CustomerVo customerVo, Set<GrantedAuthority> authorities) {
        return new User(customerVo.getUser().getUsername(), customerVo.getUser().getPassword(), true, true, true, true, authorities);
    }

}