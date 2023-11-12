package com.secure.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.dao.TaskRepository;
import com.secure.entities.Task;

@RestController
@RequestMapping("tasks")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
@GetMapping
public List<Task> getAll()
{
return taskRepository.findAll();	
}
@PostMapping
public Task addOne(@RequestBody Task task)
{
return taskRepository.save(task);	
}
}
