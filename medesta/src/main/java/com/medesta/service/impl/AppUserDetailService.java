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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;


    public AppUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with username " + username + " not found!"));
    }

    private UserDetails map(User userEntity) {

        List<Role> userRoles = new ArrayList<>();
        for (Role role : userEntity.getRoles()) {
            userRoles.add(role);
        }

        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                asGrantedAuthorities(userRoles));
    }
    private List<GrantedAuthority> asGrantedAuthorities(List<Role> roleEntities) {
        return roleEntities.
                stream().
                map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().name())).
                collect(Collectors.toList());
    }
}
