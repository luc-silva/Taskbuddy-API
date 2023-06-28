package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Todo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT td FROM Todo td WHERE td.user.id = ?1")
    public Set<Todo> listUserTodos(Integer userId);

    @Transactional
    @Modifying
    @Query("UPDATE Todo SET concluded = ?2 WHERE id = ?1")
    public void updateTodoById(Integer id, Boolean todoStatus);

    @Query("SELECT COUNT(t.concluded) FROM Todo t WHERE t.user.id = ?1 and t.concluded = true")
    public Integer countConcludedTodos(Integer userId);

    @Query("SELECT COUNT(t) FROM Todo t WHERE t.user.id = ?1")
    public Integer countTodos(Integer userId);

    @Query("SELECT td FROM Todo td WHERE td.user.id = ?1 AND (td.priority = 2 OR td.priority = 3)")
    public Set<Todo> getImportantTodosByUserId(Integer id);
}
