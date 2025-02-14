/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.mappers;

import com.walker_projects.todo.dtos.TodoDto;
import com.walker_projects.todo.entities.Todo;

/**
 *
 * @author ncossa
 */
public class TodoMapper {
    public static TodoDto mapToTodoDto(Todo todo) {
        return new TodoDto(
            todo.getId(), 
            todo.getTitle(), 
            todo.getDescription(), 
            todo.getCompleted()
        );
    }
    
    public static Todo mapTodo(TodoDto todoDto) {
        return new Todo (
            todoDto.getId(), 
            todoDto.getTitle(), 
            todoDto.getDescription(), 
            todoDto.getCompleted()
        );
    }
}
