package com.productapp.service;

import java.util.List;

import com.productapp.dao.Product;

public interface ProductService {
	public List<Product>getProducts();
	
	public Product getById(int id);
	
	public Product getByName(String name);
	
	public Product addProduct(Product product);
	public Product deleteProduct(int id);
	
	public Product updateProduct(int id, Product product);
	
	
}
