package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    @Query("SELECT User FROM UserAccount User WHERE User.email = ?1")
    public UserAccount getUserAccountByEmail(String email);
}
