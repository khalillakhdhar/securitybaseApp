package com.secure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
