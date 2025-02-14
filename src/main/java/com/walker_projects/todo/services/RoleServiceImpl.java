/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.RoleDto;
import com.walker_projects.todo.entities.Role;
import com.walker_projects.todo.mappers.RoleMapper;
import com.walker_projects.todo.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncossa
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    
    private RoleRepository roleRepo;

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = RoleMapper.mapToRole(roleDto);
        return RoleMapper.mapToDto(roleRepo.save(role));
    }
    
}
