package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.Todo;
import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.entities.UserStatus;
import com.lucsilva.taskbuddy.exceptions.NotAuthenticated;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.repositories.TodoRepository;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TodoRepository todoRepository;

    public void createAccount(UserAccount userAccount) {
        userRepository.save(userAccount);
    }

    public UserAccount getAccountByEmailAndValidate(UserAccount credentials){
        Optional<UserAccount> possibleUser = userRepository.getUserAccountByEmail(credentials.getEmail());
        if(possibleUser.isEmpty()){
            throw new NotFound("User not found with given email.");
        }
        UserAccount user = possibleUser.get();
        if(!user.getPassword().equals(credentials.getPassword())){
            throw new NotAuthenticated("Wrong Password.");
        }
        return user;
    }

    public  UserAccount getUserById(Integer id){
        Optional<UserAccount> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new NotFound("User not found.");
        } else {
            return user.get();
        }
    }

    public  Set<Project> listUserProjects(Integer id) {
        return projectRepository.listUserProjects(id);
    }
    public  Set<Todo> listUserTodos(Integer id) {
        Optional<UserAccount> userAccount = userRepository.findById(id);
        if(userAccount.isEmpty()){
            throw new NotFound("User not found.");
        }
        UserAccount user = userAccount.get();

        return todoRepository.listUserTodos(user.getId());
    }

    public UserStatus getUserStatus(Integer id){
        UserStatus status = new UserStatus();

        Integer projectTotal = projectRepository.countProjects(id);
        Integer todoTotal = todoRepository.countTodos(id);

        status.setProject_total(projectTotal);
        status.setTodo_total(todoTotal);

        Integer projectConcludedTotal = projectRepository.countConcludedProjects(id) ;
        Integer todoConcludedTotal = todoRepository.countConcludedTodos(id) ;
        status.setProject_concluded(projectConcludedTotal);
        status.setTodo_concluded(todoConcludedTotal);

        Double todoConclusionRate = (double) (todoConcludedTotal * todoTotal / 100);
        Double projectConclusionRate = (double) (projectConcludedTotal* projectTotal / 100);

        status.setProject_conclusion_rate(projectConclusionRate);
        status.setTodo_conclusion_rate(todoConclusionRate);

        return status;
    }
}
