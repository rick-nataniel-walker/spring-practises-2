/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.mappers;

import com.walker_projects.todo.dtos.RegisterDto;
import com.walker_projects.todo.entities.User;

/**
 *
 * @author ncossa
 */
public class UserMapper {
    public static RegisterDto mapToDto(User user) {
        return new RegisterDto(
            user.getId(),
            user.getName(),
            user.getUsername(),
            user.getPassword(),
            user.getEmail()
        );
    }
    
    public static User mapToUser(RegisterDto userDto) {
        return new User(
            userDto.getId(),
            userDto.getName(),
            userDto.getUsername(),
            userDto.getPassword(),
            userDto.getEmail()
        );
    }
}
