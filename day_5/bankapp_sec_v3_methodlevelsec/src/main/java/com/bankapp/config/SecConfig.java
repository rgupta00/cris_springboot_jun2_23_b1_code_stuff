package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
//how to apply method level sec

@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

//1. create a class that extends WebSecurityConfigurerAdapter 2.4---> 3.x

public class SecConfig{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//U need to write a method that configure AuthenticationProvide
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authenticationProvider
				=new DaoAuthenticationProvider();
		
		authenticationProvider.setPasswordEncoder(encode());
		
		authenticationProvider.setUserDetailsService(userDetailsService);
		return authenticationProvider;
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	//Authoritization 403
	@Bean
	protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
		return http.csrf().disable()
		.authorizeHttpRequests().anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.build();
		
	}

	
	
}




















