/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.services;

import com.walker_projects.todo.dtos.TodoDto;
import com.walker_projects.todo.entities.Todo;
import com.walker_projects.todo.exceptions.ResourceNotFoundException;
import com.walker_projects.todo.mappers.TodoMapper;
import com.walker_projects.todo.repositories.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author ncossa
 */
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{
    
    private TodoRepository todoRepo;

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = todoRepo.save(TodoMapper.mapTodo(todoDto));
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public List<TodoDto> getTodos() {
        List<Todo> todos = todoRepo.findAll();
        List<TodoDto> todoList = todos.stream()
            .map((todo) -> TodoMapper.mapToTodoDto(todo))
            .collect(Collectors.toList());
        return todoList;
    }

    @Override
    public TodoDto getTodo(Long todoId) {
        Todo todo = todoRepo.findById(todoId)
             .orElseThrow(()->new ResourceNotFoundException("Todo Not found in DB"));
        return TodoMapper.mapToTodoDto(todo);
    }

    @Override
    public TodoDto updateTodo(Long todoId, TodoDto todoDto) {
        Todo todo = todoRepo.findById(todoId)
             .orElseThrow(()->new ResourceNotFoundException("Todo Not found in DB"));
        todo.setTitle(todoDto.getTitle());
        todo.setDescription(todoDto.getDescription());
        todo.setCompleted(todoDto.getCompleted());
        
        Todo updatedTodo = todoRepo.save(todo);
        return TodoMapper.mapToTodoDto(updatedTodo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepo.findById(todoId)
             .orElseThrow(()->new ResourceNotFoundException("Todo Not found in DB"));
        
        todoRepo.deleteById(todoId);
    }
    
    @Override
    public TodoDto completeTodo(Long id) {
        Todo todo = todoRepo.findById(id)
             .orElseThrow(()->new ResourceNotFoundException("Todo Not found in DB"));
       
        todo.setCompleted(true);
        
        Todo updatedTodo = todoRepo.save(todo);
        
        return TodoMapper.mapToTodoDto(updatedTodo);
    }
    
    @Override
    public TodoDto incompleteTodo(Long id) {
        Todo todo = todoRepo.findById(id)
             .orElseThrow(()->new ResourceNotFoundException("Todo Not found in DB"));
       
        todo.setCompleted(false);
        
        Todo updatedTodo = todoRepo.save(todo);
        
        return TodoMapper.mapToTodoDto(updatedTodo);
    }
    
}
