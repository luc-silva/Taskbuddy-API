package com.lucsilva.taskbuddy.resources;

import com.lucsilva.taskbuddy.entities.Project;
import com.lucsilva.taskbuddy.repositories.ProjectRepository;
import com.lucsilva.taskbuddy.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/project")
public class ProjectResource {
    @Autowired
    ProjectService projectService;

    @PostMapping("/")
    public ResponseEntity<?> createProject(Project project){
        projectService.createProject(project);
        return ResponseEntity.ok().body("Feito.");
    }

    @PutMapping("/")
    public ResponseEntity<?> updateProject(@RequestBody Project updatedProject){
        System.out.println(updatedProject);
        projectService.updateProject(updatedProject);
        return ResponseEntity.ok().body("Feito.");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Set<Project>> getUserProjects(@PathVariable String id){
        Set<Project> projects = projectService.listUserProjects(Integer.valueOf(id));
        return ResponseEntity.ok().body(projects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable String id){
        //o user ainda tem o projeto salvo. se n ajeitar isso vai dar erro
        //tendo somento o id do projeto, uma forma de atualizar o user é procurar pelo mesmo de acordo com o dono do projeto
        projectService.deleteProjectById(Integer.valueOf(id));
        return ResponseEntity.ok().body("Feito.");
    }
}
