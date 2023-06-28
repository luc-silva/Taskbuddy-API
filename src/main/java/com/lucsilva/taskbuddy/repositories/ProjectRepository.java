package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.entities.enums.Priority;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT p FROM Project p WHERE p.user.id = ?1")
    public Set<Project> listUserProjects(Integer userId);

    @Modifying
    @Transactional
    @Query("UPDATE Project p SET p.title = ?2, p.description = ?3, p.priority = ?4, p.deadline = ?5 WHERE p.id = ?1")
    public void updateProject(Integer projectId, String projectTitle, String description, Priority priority, Date deadline);

    @Query("SELECT COUNT(p.concluded) FROM Project p WHERE p.user.id = ?1 and p.concluded = true")
    public Integer countConcludedProjects(Integer userId);

    @Query("SELECT COUNT(p) FROM Project p WHERE p.user.id = ?1")
    public Integer countProjects(Integer userId);
}
