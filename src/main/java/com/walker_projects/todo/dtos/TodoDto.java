/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ncossa
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
}
