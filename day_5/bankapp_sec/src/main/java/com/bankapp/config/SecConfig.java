package com.bankapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
//1. create a class that extends WebSecurityConfigurerAdapter 2.4
public class SecConfig extends WebSecurityConfigurerAdapter{

	//Authentication  401
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.userDetailsService(userDetailsService)
		auth.inMemoryAuthentication()
		.withUser("raj").password("raj123").roles("MGR","CLERK")
		.and()
		.withUser("ekta").password("ekta123").roles("CLERK");
	}

	@Bean
	public PasswordEncoder encode() {
		return NoOpPasswordEncoder.getInstance();
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




















