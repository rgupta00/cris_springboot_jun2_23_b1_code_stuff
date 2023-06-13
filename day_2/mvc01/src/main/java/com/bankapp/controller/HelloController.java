package com.bankapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping(path = "hellourl")
	public ModelAndView hello(ModelAndView mv) {
		mv.setViewName("mypage");//logical name of jsp
		///WEB-INF/views/mypage.jsp
		mv.addObject("message", "cris champs!");//processing result --> service --> dao
		
		return mv;
	}

}
