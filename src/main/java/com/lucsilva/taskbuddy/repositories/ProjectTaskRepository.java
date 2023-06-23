package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.ProjectTask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE ProjectTask pt SET pt.completed = :completed WHERE pt.id = :id")
    public void updateProjectTaskById(@Param("id") Integer id, @Param("completed")Boolean completed);

    @Query("SELECT pt FROM ProjectTask pt WHERE pt.project.id = ?1")
    public Set<ProjectTask> getProjectTaskByProjectId(Integer projectId);
}
