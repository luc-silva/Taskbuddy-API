package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.dto.response.ProjectTaskResponseDTO;
import com.lucsilva.taskbuddy.entities.ProjectTask;
import com.lucsilva.taskbuddy.services.ProjectService;
import com.lucsilva.taskbuddy.services.ProjectTaskService;
import com.lucsilva.taskbuddy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/project-task")
public class ProjectTaskResource {
    @Autowired
    ProjectTaskService projectTaskService;
    @Autowired
    ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectTaskResponseDTO> getProjectTask(@PathVariable Integer id){
        ProjectTask projectTask = projectTaskService.getProjectTask(id);
        return ResponseEntity.ok().body(ProjectTaskResponseDTO.convertToDto(projectTask));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateProjectTask(@PathVariable Integer id, @RequestBody ProjectTask projectTask){
        projectTaskService.updateProjectTask(projectTask, id);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

}
