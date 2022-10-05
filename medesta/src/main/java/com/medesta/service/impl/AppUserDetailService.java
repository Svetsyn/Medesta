package com.medesta.service.impl;

import com.medesta.model.entity.Role;
import com.medesta.model.entity.User;
import com.medesta.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(this::map).orElseThrow();
//                findByEmail(email).
//                map(this::map).
//                orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found."));
    }

    private UserDetails map(User userEntity) {

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                asGrantedAuthorities((List<Role>) userEntity.getRole()));
    }
    private List<GrantedAuthority> asGrantedAuthorities(List<Role> roleEntities) {
        return roleEntities.
                stream().
                map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName())).
                collect(Collectors.toList());
    }
}
