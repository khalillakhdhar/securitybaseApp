package com.secure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, String> {
	public AppRole findByRoleName(String roleName);

}
