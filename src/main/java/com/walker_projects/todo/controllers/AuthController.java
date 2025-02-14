/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.controllers;

import com.walker_projects.todo.dtos.LoginDto;
import com.walker_projects.todo.dtos.RegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.walker_projects.todo.services.AuthService;

/**
 *
 * @author ncossa
 */
@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    
    private AuthService authService;
    
    @PostMapping("/register")
    public ResponseEntity<RegisterDto> createUser(@RequestBody RegisterDto userDto) {
        RegisterDto user = authService.register(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
