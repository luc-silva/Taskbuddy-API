package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.dto.request.ProjectRequestDTO;
import com.lucsilva.taskbuddy.dto.response.ProjectResponseDTO;
import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.services.ProjectService;
import com.lucsilva.taskbuddy.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/project")
public class ProjectResource {
    @Autowired
    ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDTO> getProject(@PathVariable Integer id){
        Project project = projectService.getProjectById(id);
        return ResponseEntity.ok().body(ProjectResponseDTO.convertToDto(project));
    }

    @PostMapping("/")
    public ResponseEntity<ResponseMessage> createProject(@RequestBody ProjectRequestDTO projectDto) {
        projectService.createProject(projectDto.convertToObject());
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @PutMapping("/")
    public ResponseEntity<ResponseMessage> updateProject(@RequestBody Project updatedProject) {
        projectService.updateProject(updatedProject);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteProject(@PathVariable Integer id) {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok().body(new ResponseMessage("Done."));
    }
}
