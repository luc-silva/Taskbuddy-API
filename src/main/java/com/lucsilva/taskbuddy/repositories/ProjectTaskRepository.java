package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ProjectTask SET completed = ?2 WHERE id = ?1")
    public void updateProjectTaskById(Integer id, Boolean completed);
}
