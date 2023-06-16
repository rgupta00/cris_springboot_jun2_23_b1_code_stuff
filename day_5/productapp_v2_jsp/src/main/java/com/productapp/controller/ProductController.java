package com.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.productapp.service.ProductService;

@Controller
public class ProductController {
	
	public ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping(path = "products")
	public ModelAndView showAll(ModelAndView mv) {
		mv.setViewName("products");
		mv.addObject("products", productService.getProducts());
		
		return mv;
	}
	

}












