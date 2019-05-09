package com.kanbanBoard.demo.controller;

import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanBoard.demo.exception.ResourceNotFoundException;
import com.kanbanBoard.demo.model.Project;
import com.kanbanBoard.demo.repository.ProjectRepository;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("/api/v1/projects")
	public Page<Project> getAllProjects(Pageable pageable){
		return projectRepository.findAll(pageable);
	}
	
	@GetMapping("/api/v2/projects")
	public Page<Project> findProjects(Pageable pageable){
		return projectRepository.findAllProjects(pageable);
	}
	
	@PostMapping("/api/new-project")
	public Project createNewProject(@Valid @RequestBody Project project) {
		return projectRepository.save(project);
		
	}
	
	@PutMapping("/api/update-project/{projectId}")
	public Project updateProject(@PathVariable Long projectId, @Valid @RequestBody Project projectRequest) {
		return projectRepository.findById(projectId).map(project -> {
			project.setName(projectRequest.getName());
			project.setDescription(projectRequest.getDescription());
			return projectRepository.save(project);			
		}).orElseThrow(() -> new ResourceNotFoundException("Project Id " + projectId + " not found"));
		
	}
	
	@DeleteMapping("/api/delete-project/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId) {
        return projectRepository.findById(projectId).map(post -> {
        	projectRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Project ID " + projectId + " not found"));
    }
	

	
	
	

}
