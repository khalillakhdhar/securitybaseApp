package com.secure;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.secure.dao.TaskRepository;
import com.secure.entities.AppRole;
import com.secure.entities.AppUser;
import com.secure.entities.Task;
import com.secure.web.AccountService;

@SpringBootApplication
public class SecuritybaseAppApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(SecuritybaseAppApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		accountService.saveUser(new AppUser("admin", "1234",1,null));
		accountService.saveUser(new AppUser("user", "1234",1,null));
		accountService.saveRole(new AppRole("ROLE_ADMIN"));
		accountService.saveRole(new AppRole("ROLE_USER"));
		accountService.addRoleToUser("admin", "ROLE_ADMIN");
		accountService.addRoleToUser("user", "ROLE_USER");
		Stream.of("T1","T2","T3").forEach(t->{
			taskRepository.save(new Task(t));
			});
			taskRepository.findAll().forEach(t->{
			System.out.println(t.getTaskName());
			});

	}

}
