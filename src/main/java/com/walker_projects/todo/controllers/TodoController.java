/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.controllers;

import com.walker_projects.todo.dtos.TodoDto;
import com.walker_projects.todo.services.TodoService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ncossa
 */
@RestController
@RequestMapping("/api/todos")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto todoDto) {
        TodoDto todo = todoService.createTodo(todoDto);
        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<TodoDto>> getTodos() {
        List<TodoDto> todoList = todoService.getTodos();
        return ResponseEntity.ok(todoList);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable Long id) {
        TodoDto todo = todoService.getTodo(id);
        return ResponseEntity.ok(todo);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok(updatedTodo);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/completed")
    public ResponseEntity<TodoDto> completedTodo(@PathVariable Long id) {
        TodoDto completeTodo = todoService.completeTodo(id);
        return ResponseEntity.ok(completeTodo);
    }
    
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("{id}/incompleted")
    public ResponseEntity<TodoDto> incompletedTodo(@PathVariable Long id) {
        TodoDto completeTodo = todoService.incompleteTodo(id);
        return ResponseEntity.ok(completeTodo);
    }
}
