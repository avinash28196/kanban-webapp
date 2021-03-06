package com.kanbanBoard.demo.model;

import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SuppressWarnings("serial")
@Entity
@EnableJpaAuditing

public class Project extends AuditModel{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String name;
	
	private String description;
	
	@OneToMany(targetEntity = Tasks.class, fetch = FetchType.LAZY)
	private Set<Tasks> task;
	
	
	public Project() {

	}
			

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Tasks> getTask() {
		return task;
	}

	public void setTask(Set<Tasks> task) {
		this.task = task;
	}	
	
}
