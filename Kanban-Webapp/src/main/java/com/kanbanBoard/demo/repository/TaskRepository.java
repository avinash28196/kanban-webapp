package com.kanbanBoard.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kanbanBoard.demo.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{
	
	Page<Tasks> findById(Long projectId, Pageable pageable);
	
	Optional<Tasks> findByIdAndProject_Id(Long id,Long projectId);
	
	Page<Tasks> findByProject_Id(Long projectId, Pageable pageable);
	
	@Query("select tasks from Tasks tasks where project_id = ?1")
	Page<Tasks> findProjectsTask(Long projectId, Pageable pagabale);
	
	
	
}
