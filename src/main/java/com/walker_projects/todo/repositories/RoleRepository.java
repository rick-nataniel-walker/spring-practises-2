/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.todo.repositories;

import com.walker_projects.todo.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ncossa
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    public Role findByName(String name);
}
