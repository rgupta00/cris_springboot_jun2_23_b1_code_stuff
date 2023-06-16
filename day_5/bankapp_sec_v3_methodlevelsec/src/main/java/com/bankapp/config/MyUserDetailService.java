package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.entity.UserEntity;
import com.bankapp.service.UserService;

@Service
public class MyUserDetailService implements UserDetailsService {

	
	private UserService userService;
	
	@Autowired
	public MyUserDetailService(UserService userService) {
		this.userService = userService;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity=userService.findByUsername(username);
		
		System.out.println("---------------------------------");
		System.out.println(userEntity);
		
		System.out.println("---------------------------------");
		if(userEntity==null)
			throw new UsernameNotFoundException("username/password is not correct");
		
		//i need to convert this object to the object that spring sec understand
		//how to do it?
		//i need to create a new class that impl UserDetails interface and covnert my user
		//to the user that spring sec understand ?
		
		return new SecUser(userEntity);
	}

}









