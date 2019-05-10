package com.kanbanBoard.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kanbanBoard.demo.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>{

}
