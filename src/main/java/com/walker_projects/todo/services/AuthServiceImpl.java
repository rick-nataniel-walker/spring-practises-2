/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.LoginDto;
import com.walker_projects.todo.dtos.RegisterDto;
import com.walker_projects.todo.entities.Role;
import com.walker_projects.todo.entities.User;
import com.walker_projects.todo.exceptions.TodoApiException;
import com.walker_projects.todo.mappers.UserMapper;
import com.walker_projects.todo.repositories.RoleRepository;
import com.walker_projects.todo.repositories.UserRepository;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncossa
 */
@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepo;
    private RoleRepository roleRepo;
    private PasswordEncoder pEncoder;
    private AuthenticationManager authManager;

    @Override
    public RegisterDto register(RegisterDto userDto) {

        //converter user
        User user = UserMapper.mapToUser(userDto);
        
        //check user;
       if( userRepo.existsByUsername(user.getUsername())) {
           throw new TodoApiException(HttpStatus.BAD_REQUEST, "username already taken");
       }
       
       if( userRepo.existsByEmail(user.getEmail())) {
           throw new TodoApiException(HttpStatus.BAD_REQUEST, "email already taken");
       }
        
        
        Set<Role> roles = new HashSet();
        Role userRole = roleRepo.findByName("ROLE_USER");
        roles.add(userRole);
        
        user.setRoles(roles);
        user.setPassword(pEncoder.encode(userDto.getPassword()));
        //save it
        return UserMapper.mapToDto(userRepo.save(user));
    }

    @Override
    public String login(LoginDto loginDto) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
            loginDto.getUsernameOrEmail(),
            loginDto.getPassword()
        ));
        
        SecurityContextHolder.getContext().setAuthentication(auth);
        
        return "User logged-in successfully";
    }

}
