package com.secure.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Autowired
	// authentification
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("USER","ADMIN");
	auth.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
	}
	// authorisation
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin();
	http.csrf().disable();
	http.authorizeRequests().antMatchers("/login/**","register/**").permitAll();
	http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasRole("ADMIN");
	http.authorizeRequests().anyRequest().authenticated();

	}
}
