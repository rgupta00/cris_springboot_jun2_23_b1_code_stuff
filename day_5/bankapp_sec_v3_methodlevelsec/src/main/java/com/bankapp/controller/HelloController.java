package com.bankapp.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.SecUser;

@RestController
public class HelloController {
	
	@GetMapping(path = "home")
	public String home() {
		return "home";
	}
	
	
	@PreAuthorize("hasAuthority('ROLE_MGR')")
	@GetMapping(path = "mgr")
	public String mgr(Principal principal) {
		System.out.println("currently logged in user: "+ principal.getName());
		return "mgr";
	}
	
	//@Secured({"MGR", "CLERK"})
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	@GetMapping(path = "clerk")
	public String clerk(@AuthenticationPrincipal SecUser secUser ) {
		
		System.out.println(secUser.getUserEntity());
		System.out.println("currently logged in user: ");
		return "clerk";
	}
	

}







