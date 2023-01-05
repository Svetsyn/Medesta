package com.medesta.config;

import com.medesta.model.enums.RoleName;
import com.medesta.repository.UserRepository;
import com.medesta.service.impl.AppUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/js/**", "/css/**", "/img/**").permitAll().
                // todo allow CSS at "common" static location (static/css)
//                        requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().
                // permit home page, login and registration pages for anyone
                        antMatchers("/", "/users/login", "/users/register").permitAll()
                .antMatchers("/home").hasRole(RoleName.ADMIN.name())
                .anyRequest()
                .authenticated();
//                .antMatchers("/home").hasRole(RoleName.ADMIN.name())
//                .anyRequest();
//                        .
//                // allow for moderators
////                        antMatchers("/home").hasRole(RoleName.RECEPTIONIST.name()).
//        antMatchers("/home").hasRole(RoleName.ADMIN.name()).
//                // allow for admins
//                        antMatchers("/roles/add").hasRole(RoleName.ADMIN.name()).
//                // any remaining reqests should be authenticated
//                        anyRequest().
//                authenticated().
//                and().
//                formLogin().
//                loginPage("/users/login").
//                usernameParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
//                passwordParameter(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
//                defaultSuccessUrl("/").
//                failureForwardUrl("/users/login-error").//todo
//                and().
//                logout().
//                logoutUrl("/users/logout").
//                logoutSuccessUrl("/").
//                invalidateHttpSession(true).
//                deleteCookies("JSESSIONID");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new AppUserDetailService(userRepository);
    }



//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.
//                userDetailsService(userDetailsService).
//                passwordEncoder(passwordEncoder);
//    }
}
