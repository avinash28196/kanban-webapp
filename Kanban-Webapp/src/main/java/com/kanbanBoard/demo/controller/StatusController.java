package com.kanbanBoard.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanBoard.demo.model.Status;
import com.kanbanBoard.demo.model.Tasks;
import com.kanbanBoard.demo.repository.ProjectRepository;
import com.kanbanBoard.demo.repository.StatusRepository;
import com.kanbanBoard.demo.repository.TaskRepository;

@RestController
public class StatusController {

	
    @Autowired
    private StatusRepository statusRepository;
    
    @Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	
	
}
