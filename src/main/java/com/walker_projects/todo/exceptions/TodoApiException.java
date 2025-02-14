/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.walker_projects.todo.exceptions;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author ncossa
 */
@Getter
@AllArgsConstructor
public class TodoApiException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
