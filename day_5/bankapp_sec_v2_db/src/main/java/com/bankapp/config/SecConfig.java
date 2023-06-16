package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
//1. create a class that extends WebSecurityConfigurerAdapter 2.4
public class SecConfig extends WebSecurityConfigurerAdapter{

	//Authentication  401
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
		
//		return NoOpPasswordEncoder.getInstance();
	}
	
	//Authoritization 403
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//we cannot the session hijecking as we will not use cookies
		
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/mgr/**").hasAnyRole("MGR")
		.antMatchers("/clerk/**").hasAnyRole("MGR","CLERK")
		.antMatchers("/home/**").permitAll()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	
	
}




















