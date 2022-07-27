package com.medesta.config;

import com.medesta.model.entity.Role;
import com.medesta.model.enums.RoleName;
import com.medesta.service.impl.AppUserDetailService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserDetailService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(AppUserDetailService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http exposes api that allows us configure the web security
        http.
                // which pages will be authorized?
                        authorizeRequests().
                antMatchers("/js/**","/css/**","/img/**").permitAll().
                // todo allow CSS at "common" static location (static/css)
//                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                // permit home page, login and registration pages for anyone
                        antMatchers("/", "/users/login", "/users/register").permitAll().
                // allow for moderators
                        antMatchers("/pages/moderators").hasRole(RoleName.RECEPTIONIST.name()).
                // allow for admins
                        antMatchers("/roles/add").hasRole(RoleName.ADMIN.name()).
                // any remaining reqests should be authenticated
                        anyRequest().
                authenticated().
                and().
                formLogin().
                loginPage("/users/login").
                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                defaultSuccessUrl("/home").
                failureForwardUrl("/users/login-error").//todo
                and().
                logout().
                logoutUrl("/users/logout").
                logoutSuccessUrl("/home").
                invalidateHttpSession(true).
                deleteCookies("JSESSIONID");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
                userDetailsService(userDetailsService).
                passwordEncoder(passwordEncoder);
    }
}
