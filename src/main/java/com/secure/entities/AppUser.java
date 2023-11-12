package com.secure.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
@Id
private String username;
private String password;
private int active;
@ManyToMany(fetch = FetchType.EAGER)
private Collection<AppRole> roles = new ArrayList<>();
}
