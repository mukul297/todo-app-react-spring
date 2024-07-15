package com._x.todo.service;

import com._x.todo.model.Todo;
import com._x.todo.repository.TodoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    public TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void putTodos(Todo todo) {
        todoRepository.insert(todo);
    }

    public void updateTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

}
