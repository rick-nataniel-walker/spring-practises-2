/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.LoginDto;
import com.walker_projects.todo.dtos.RegisterDto;

/**
 *
 * @author ncossa
 */
public interface AuthService {
    public RegisterDto register(RegisterDto userDto);
    public String login(LoginDto loginDto);
}
