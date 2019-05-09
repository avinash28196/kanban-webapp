package com.kanbanBoard.demo.repository;

import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kanbanBoard.demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Query("select project from Project project")
	Page<Project> findAllProjects(Pageable pageable);
	
	

}
