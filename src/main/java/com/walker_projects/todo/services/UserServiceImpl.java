/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.UserDto;
import com.walker_projects.todo.entities.User;
import com.walker_projects.todo.mappers.UserMapper;
import com.walker_projects.todo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncossa
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {

        PasswordEncoder pEncoder = new BCryptPasswordEncoder();
        //converter user
        User user = UserMapper.mapToUser(userDto);
        user.setPassword(pEncoder.encode(userDto.getPassword()));

        //save it
        return UserMapper.mapToDto(userRepo.save(user));
    }

}
