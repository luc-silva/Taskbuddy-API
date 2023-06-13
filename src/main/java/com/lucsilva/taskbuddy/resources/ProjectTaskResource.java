package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.services.ProjectService;
import com.lucsilva.taskbuddy.services.ProjectTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project-task")
public class ProjectTaskResource {
    @Autowired
    ProjectTaskService projectTaskService;
    @Autowired
    ProjectService projectService;

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProjectTask(@PathVariable Integer id, @RequestBody ProjectTask projectTask){
        projectTaskService.updateProjectTask(projectTask, id);
        return ResponseEntity.ok().body("Feito.");
    }

}
