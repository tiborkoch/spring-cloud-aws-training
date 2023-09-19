package cloud.training.aws.oauth2.resourceserver.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.training.aws.oauth2.resourceserver.repository.CustomerRepository;
import cloud.training.aws.oauth2.resourceserver.domain.Customer;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        Customer customer = repository.findByEmail(emailAddress);

        if (customer == null) {
            throw new UsernameNotFoundException("No customer found with email address: " + emailAddress);
        }

        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(customer.getRole().toString());

        /*
        the previous line does the following, check the source of AuthorityUtils for details

        Set<GrantedAuthority> authorities = new HashSet<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole().toString());
        authorities.add(authority);
        */

        UserDetails principal = User.withUsername(emailAddress).authorities(authorities).password(customer.getPassword()).build();

        /*
        the previous line is a shorthand for this (it converts our domain user, which is of type Orc to
        Spring security's user which is of type UserDetails)

        org.springframework.security.core.userdetails.User principal =
                new org.springframework.security.core.userdetails.User(orcName, customer.getPassword(), authorities);
         */
        return principal;
    }

}
