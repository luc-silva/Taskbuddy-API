package com.lucsilva.taskbuddy.repositories;

import com.lucsilva.taskbuddy.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
