package com.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.dao.ProductDao;
import com.productapp.dto.Product;

import reactor.core.publisher.Flux;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;
	
	 public List<Product> loadAllProducts() {
	        long start = System.currentTimeMillis();
	        List<Product> products = dao.getProducts();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return products;
	    }



	    public Flux<Product> loadAllProductStream() {
	        long start = System.currentTimeMillis();
	        Flux<Product> customers = dao.getProducttream();
	        long end = System.currentTimeMillis();
	        System.out.println("Total execution time : " + (end - start));
	        return customers;
	    }
}
