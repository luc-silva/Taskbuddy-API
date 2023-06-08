package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.ProjectTask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ProjectTask pt SET pt.completed = ?1 WHERE pt.id = ?2")
    public void updateProjectById(Boolean isCompleted, Integer id);

}
