package com.kanbanBoard.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanBoard.demo.model.Tasks;
import com.kanbanBoard.demo.repository.ProjectRepository;
import com.kanbanBoard.demo.repository.TaskRepository;

@RestController
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@GetMapping("api/v1/projects/{projectId}/tasks")
	public Page<Tasks> getTasksByProjectId(@PathVariable (value = "projectId") int projectId,Pageable pageable){
		return taskRepository.findByProject_Id(projectId, pageable)	;
	}
	
	@GetMapping("api/v2/projects/{projectId}/tasks")
	public Page<Tasks> getTaskList(@PathVariable (value = "projectId") int projectId, Pageable pageable){
		return taskRepository.findProjectsTask(projectId, pageable);
		
	}
	
	
	

}
