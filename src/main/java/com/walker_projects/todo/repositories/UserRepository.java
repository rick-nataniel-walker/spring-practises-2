/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.todo.repositories;

import com.walker_projects.todo.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ncossa
 */
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

    public Boolean existsByEmail(String email);
    
    public Boolean existsByUsername(String username);

    public Optional<User> findByUsernameOrEmail(String username, String email);

}
