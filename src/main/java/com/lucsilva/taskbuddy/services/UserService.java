package com.lucsilva.taskbuddy.services;

import com.lucsilva.taskbuddy.entities.UserAccount;
import com.lucsilva.taskbuddy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserAccount createAccount(UserAccount userAccount) {
        return userRepository.save(userAccount);
    }

    public UserAccount getAccountByEmail(String email){
        return userRepository.getUserAccountByEmail(email);
    }

    public  UserAccount getUserById(Integer id){
        Optional<UserAccount> userAccount = userRepository.findById(id);
        //returns null if null (duh)
        return userAccount.orElse(null);
    }

}
