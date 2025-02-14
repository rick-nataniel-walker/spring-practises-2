/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.controllers;

import com.walker_projects.todo.dtos.RoleDto;
import com.walker_projects.todo.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ncossa
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;
    
    @PostMapping
    public ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        RoleDto newRole = roleService.createRole(roleDto);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
}
