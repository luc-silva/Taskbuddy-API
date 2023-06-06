package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {
}
