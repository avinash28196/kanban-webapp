package com.kanbanBoard.demo.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	
	
	

}
