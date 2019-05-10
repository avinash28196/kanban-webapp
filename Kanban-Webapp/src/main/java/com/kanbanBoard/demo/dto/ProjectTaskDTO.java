package com.kanbanBoard.demo.dto;

public class ProjectTaskDTO {
	
	private String name;
	private String description;
	private String taskName;
	private String taskDescription;
	
	

	
	public ProjectTaskDTO(String name, String description, String taskName, String taskDescription) {
		super();
		this.name = name;
		this.description = description;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String description) {
		this.taskDescription = description;
	}
	
	
	

}
