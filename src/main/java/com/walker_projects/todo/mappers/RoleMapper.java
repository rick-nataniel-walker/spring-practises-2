/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.mappers;

import com.walker_projects.todo.dtos.RoleDto;
import com.walker_projects.todo.entities.Role;

/**
 *
 * @author ncossa
 */
public class RoleMapper {
    public static RoleDto mapToDto(Role role) {
        return new RoleDto(role.getId(), role.getName());
    }
    
    public static Role mapToRole(RoleDto roleDto) {
        return new Role(roleDto.getId(), roleDto.getName());
    }
}
