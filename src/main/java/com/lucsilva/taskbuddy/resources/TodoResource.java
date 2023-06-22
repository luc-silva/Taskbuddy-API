package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.dto.response.TodoResponseDTO;
import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.services.TodoService;
import com.lucsilva.taskbuddy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/todo")
public class TodoResource {
    @Autowired
    TodoService todoService;

    @PostMapping("/")
    public ResponseEntity<ResponseMessage> createTodo(@RequestBody Todo todo){
        todoService.createTodo(todo);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteTodo(@PathVariable Integer id){
        todoService.deleteTodoById(id);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateTodo(@PathVariable Integer id, @RequestBody Todo updatedTodo){
        todoService.updateTodoById(id, updatedTodo);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> getTodo(@PathVariable Integer id){
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok().body(TodoResponseDTO.covertToDTO(todo));
    }
}
