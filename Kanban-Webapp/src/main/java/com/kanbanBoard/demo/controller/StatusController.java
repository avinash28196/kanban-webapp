package com.kanbanBoard.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kanbanBoard.demo.repository.StatusRepository;

@RestController
public class StatusController {

	
    @Autowired
    private StatusRepository statusRepository;
    
    
}
