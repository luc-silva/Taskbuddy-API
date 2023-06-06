package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
