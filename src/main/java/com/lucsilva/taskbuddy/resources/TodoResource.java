package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todo")
public class TodoResource {
    @Autowired
    TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<?> createTodo(@RequestBody Todo todo){
        todoService.createTodo(todo);
        return ResponseEntity.ok().body("Done.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
        todoService.deleteTodoById(id);
        return ResponseEntity.ok().body("Done.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodo){
        todoService.updateTodoById(id, updatedTodo);
        return ResponseEntity.ok().body("Done.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer id){
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok().body(todo);
    }
}
