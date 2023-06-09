package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.exceptions.NotAuthenticated;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

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

}
