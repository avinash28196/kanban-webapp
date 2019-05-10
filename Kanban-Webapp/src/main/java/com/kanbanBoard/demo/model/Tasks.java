package com.kanbanBoard.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tasks extends AuditModel{

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String taskName; 
	private String taskDescription;
	
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "due_date",updatable = true)
	 @CreatedDate
	 private Date due_date;
	 	
	
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "project_id", nullable = false)
	 @Fetch(FetchMode.JOIN)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private Project project;
	 
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 @JoinColumn(name = "status_id", nullable = false)
	 @Fetch(FetchMode.JOIN)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
	 private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String name) {
		this.taskName = name;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String description) {
		this.taskDescription = description;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	 
	 public Tasks() {
		 
	 }
	 
	 
	 
	 
	
}
