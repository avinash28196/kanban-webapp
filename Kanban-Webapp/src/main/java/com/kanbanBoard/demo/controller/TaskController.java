package com.kanbanBoard.demo.controller;

import java.util.Optional;

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
import com.kanbanBoard.demo.model.Status;
import com.kanbanBoard.demo.model.Tasks;
import com.kanbanBoard.demo.repository.ProjectRepository;
import com.kanbanBoard.demo.repository.StatusRepository;
import com.kanbanBoard.demo.repository.TaskRepository;

@RestController
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Autowired
	private StatusRepository statusRepository;
	
	@GetMapping("api/v1/projects/{projectId}/tasks")
	public Page<Tasks> getTasksByProjectId(@PathVariable (value = "projectId") Long projectId,Pageable pageable){
		return taskRepository.findByProject_Id(projectId, pageable)	;
	}
	
	@GetMapping("api/v2/projects/{projectId}/tasks")
	public Page<Tasks> getTaskList(@PathVariable (value = "projectId") Long projectId, Pageable pageable){
		return taskRepository.findProjectsTask(projectId, pageable);		
	}
	
	
	
	@PostMapping("/api/project/{projectId}/Task")
	public Tasks createTask(@PathVariable (value = "projectId") Long projectId, @Valid @RequestBody Tasks task, Status status) {
		 statusRepository.save(status);
	     return projectRepository.findById(projectId).map(project -> {
	    	 task.setProject(project);
	    	 task.setName(task.getName());
	    	 task.setDescription(task.getDescription());
	    	 task.setDue_date(task.getDue_date());
	    	 status.setStatus(status.getStatus());
	    	 task.setStatus(status);	    	 
	     return taskRepository.save(task);	     
	     }).orElseThrow(() -> new ResourceNotFoundException("Task Id " + projectId + " not found"));
	 }
	
	@PutMapping("/api/project/{projectId}/edit-task/{taskId}")
	public Tasks updateTask(@PathVariable (value = "projectId") Long projectId,
							@PathVariable ( value = "taskId") Long taskId,
							@Valid @RequestBody Tasks taskRequest) {
		if(!projectRepository.existsById(projectId)) {
			throw new ResourceNotFoundException("Project Id " + projectId + " not found");
		}
		return taskRepository.findById(taskId).map(task ->{
			task.setName(taskRequest.getName());
			task.setDescription(taskRequest.getDescription());
			task.setDue_date(taskRequest.getDue_date());
			return taskRepository.save(task);
		}).orElseThrow(() -> new ResourceNotFoundException("Task Id " + taskId + "not found"));
	}
			
	@DeleteMapping("api/project/{projectId}/delete-task/{taskId}")
	public ResponseEntity<?> deleteTask(@PathVariable (value = "projectId") Long projectId,
										@PathVariable ( value = "taskId") Long taskId){
		return taskRepository.findByIdAndProject_Id(taskId, projectId).map(task -> {
			taskRepository.delete(task);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId + " for ProjectId " + projectId));
	}
	
	
	

}
