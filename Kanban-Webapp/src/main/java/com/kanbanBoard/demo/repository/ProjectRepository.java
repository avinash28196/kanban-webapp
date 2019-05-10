package com.kanbanBoard.demo.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kanbanBoard.demo.dto.ProjectTaskDTO;
import com.kanbanBoard.demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Query("select project from Project project")
	Page<Project> findAllProjects(Pageable pageable);
	
	
	
	@Query("SELECT new com.kanbanBoard.demo.dto.ProjectTaskDTO(project.name, project.description, task.taskName,task.taskDescription )"
			+ "FROM Project project, Tasks task")
	List<ProjectTaskDTO> fetchData();
	

}
