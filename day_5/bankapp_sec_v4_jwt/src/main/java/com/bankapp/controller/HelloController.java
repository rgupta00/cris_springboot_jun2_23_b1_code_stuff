package com.bankapp.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.config.JwtService;
import com.bankapp.config.SecUser;
import com.bankapp.dto.AuthRequest;

@RestController
public class HelloController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	// i want to bypass this endpoint "authenticate"

	@PostMapping(path = "authenticate")
	public String authenticate(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));

		//this method authentication.isAuthenticated() is using DaoAuthenticationProvider to check
		//user details
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		}else {
			throw new UsernameNotFoundException("invalid user");
		}
	}

	@GetMapping(path = "home")
	public String home() {
		return "home";
	}

	@PreAuthorize("hasAuthority('ROLE_MGR')")
	@GetMapping(path = "mgr")
	public String mgr(Principal principal) {
		System.out.println("currently logged in user: " + principal.getName());
		return "mgr";
	}

	// @Secured({"MGR", "CLERK"})
	@PreAuthorize("hasAuthority('ROLE_MGR') or hasAuthority('ROLE_CLERK')")
	@GetMapping(path = "clerk")
	public String clerk(@AuthenticationPrincipal SecUser secUser) {

		System.out.println(secUser.getUserEntity());
		System.out.println("currently logged in user: ");
		return "clerk";
	}

}
