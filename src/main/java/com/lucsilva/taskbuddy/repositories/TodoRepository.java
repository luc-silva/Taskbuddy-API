package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT Todo FROM Todo WHERE user = ?1")
    public Set<Todo> listUSerTodos(Integer userId);

    @Transactional
    @Modifying
    @Query("UPDATE Todo SET concluded = ?2 WHERE id = ?1")
    public void updateTodoById(Integer id, Boolean todoStatus);
}
