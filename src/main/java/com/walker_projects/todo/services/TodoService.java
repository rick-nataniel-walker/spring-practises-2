/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.TodoDto;
import java.util.List;

/**
 *
 * @author ncossa
 */
public interface TodoService {
    
    public TodoDto createTodo(TodoDto todoDto);
    
    public List<TodoDto> getTodos();
    
    public TodoDto getTodo(Long todoId);
    
    public TodoDto updateTodo(Long todoId, TodoDto todoDto);   
    
    public void deleteTodo(Long todoId);
    
    public TodoDto completeTodo(Long id);
    
    public TodoDto incompleteTodo(Long id);
    
}
