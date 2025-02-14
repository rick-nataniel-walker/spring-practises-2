/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.walker_projects.todo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author ncossa
 */
@Configuration
@EnableMethodSecurity
public class SpringSecurityConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
            .authorizeHttpRequests((auth) -> {
                auth.requestMatchers(HttpMethod.POST, urlPatterns).hasRole(this.admin);
                auth.requestMatchers(HttpMethod.PUT, urlPatterns).hasRole(this.admin);
                auth.requestMatchers(HttpMethod.DELETE, urlPatterns).hasRole(this.admin);
                auth.requestMatchers(HttpMethod.PATCH, urlPatterns).hasAnyRole(this.admin, this.user);
                auth.requestMatchers(HttpMethod.GET, urlPatterns).permitAll();
                auth.anyRequest().authenticated();
            })
            .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        
        UserDetails walker = User.builder()
            .username("walker")
            .password(passwordEncoder().encode("12w34567"))
            .roles("USER")
            .build();
        
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder().encode("Admin"))
            .roles("ADMIN")
            .build();
        
        return new InMemoryUserDetailsManager(walker, admin);
    }
}
