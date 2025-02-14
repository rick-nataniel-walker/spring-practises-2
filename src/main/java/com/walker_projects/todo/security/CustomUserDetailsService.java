/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.security;

import com.walker_projects.todo.entities.User;
import com.walker_projects.todo.repositories.UserRepository;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author ncossa
 */
public class CustomUserDetailsService implements UserDetailsService {
    
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userRepo.findByUsernameOrEmail(username, username)
                .orElseThrow(() -> new UsernameNotFoundException("User does not exists"));
        
        Set<GrantedAuthority> auths = user.getRoles().stream()
                .map((role) -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
        
        return new org.springframework.security.core.userdetails.User(
            username, null, auths
        );
    }
    
}
