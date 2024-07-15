package com._x.todo.controller;

import com._x.todo.model.Todo;
import com._x.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:5176/")
public class TodoController {

    @Autowired
    public TodoService todoService;

    @GetMapping({"/todos"})
    public ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<>(todoService.getAllTodos(), HttpStatus.OK);
    }

    @PostMapping({"/todo"}) // POST - create new todo
    public ResponseEntity handleTodo(@RequestBody Todo todo){
        todoService.putTodos(todo);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping({"/completed"})
    public ResponseEntity handleCompleted(@RequestBody Todo todo){
        List<Todo> todos = todoService.findAll();
        for(Todo todo1: todos) {
            if(todo1.getId().equals(todo.getId())) {
                todo.setCompleted(true);
                todoService.updateTodo(todo);
                return new ResponseEntity(todo, HttpStatus.OK);
            }
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
