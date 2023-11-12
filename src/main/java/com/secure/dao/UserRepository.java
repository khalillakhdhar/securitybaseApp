package com.secure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, String> {
	public AppUser findByUsername(String username);

}
