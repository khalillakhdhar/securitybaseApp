package com.secure.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Task {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String taskName;
public Task(String taskName) {
	super();
	this.taskName = taskName;
}



}
