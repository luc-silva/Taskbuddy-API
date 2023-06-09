package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project")
public class ProjectResource {
    @Autowired
    ProjectService projectService;

    @PostMapping("/")
    public ResponseEntity<?> createProject(@RequestBody Project project) {
        projectService.createProject(project);
        return ResponseEntity.ok().body("Feito.");
    }

    @PutMapping("/")
    public ResponseEntity<?> updateProject(@RequestBody Project updatedProject) {
        projectService.updateProject(updatedProject);
        return ResponseEntity.ok().body("Feito.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable String id) {
        projectService.deleteProjectById(Integer.valueOf(id));
        return ResponseEntity.ok().body("Feito.");
    }
}
