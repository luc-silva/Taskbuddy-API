package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import com.lucsilva.taskbuddy.repositories.TodoRepository;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    public void createTodo(Todo todo){
        if(todo.getUser() == null){
            throw new IllegalArgumentException("To-do must have an owner.");
        }
        Optional<UserAccount> userAccount = userRepository.findById(todo.getUser().getId());
        if(userAccount.isEmpty()){
            throw new NotFound("User not found.");
        }

        UserAccount user = userAccount.get();
        user.getTodos().add(todo);

        userRepository.save(user);
        todoRepository.save(todo);
    }

    public void deleteTodoById(Integer id){ todoRepository.deleteById(id);}

    public void updateTodoById(Integer id, Todo todo){ todoRepository.updateTodoById(id, todo.getConcluded()); }

    public Todo getTodoById(Integer id){
        Optional<Todo> todo = todoRepository.findById(id);
        if(todo.isEmpty()){
            throw new NotFound("To-do not found.");
        }
        return todo.get();
    }


}
