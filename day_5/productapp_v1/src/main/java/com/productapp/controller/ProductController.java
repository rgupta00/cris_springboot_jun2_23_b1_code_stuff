package com.productapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dao.Product;
import com.productapp.service.ProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	//-------get all----------
	@GetMapping(path = "products")
	public List<Product> getAll(){
		return productService.getProducts();
	}
	
	//-------get by id----------
	@GetMapping(path = "products/{id}")
	public Product getById(@PathVariable(name="id")  int id){
		return productService.getById(id);
	}
	
	//--------- delete by id----------
	//how to send correct status code
	
//	@DeleteMapping(path = "products/{id}")
//	public ResponseEntity<Void> deleteByid(@PathVariable(name="id")  int id){
//		 productService.deleteProduct(id);
//		 return ResponseEntity.status(HttpStatus.NO_CONTENT)
//				 .build();
//		 
//	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "products/{id}")
	public void deleteByid(@PathVariable(name="id")  int id){
		 productService.deleteProduct(id);
	}
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(path = "products")
	public Product addProduct( @RequestBody  @Valid Product product) {
		return productService.addProduct(product);
	}
	
	@PutMapping(path = "products/{id}")
	public Product updateProduct( @PathVariable(name="id")  int id,
			@RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

}








