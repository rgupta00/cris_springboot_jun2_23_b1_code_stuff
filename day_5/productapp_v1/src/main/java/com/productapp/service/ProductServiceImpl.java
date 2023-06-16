package com.productapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.dao.Product;
import com.productapp.dao.ProductRepo;
import com.productapp.exceptions.ProductNotFoundException;

import io.swagger.v3.oas.annotations.servers.Server;
@Service
public class ProductServiceImpl implements ProductService{

	private Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	private ProductRepo productDao;
	
	@Autowired
	public void setProductDao(ProductRepo productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProducts() {
		long start=System.currentTimeMillis();
		
		logger.info("*************************getProduct method is being called*************************");
		List<Product> products= productDao.findAll();
		long end=System.currentTimeMillis();
		logger.info("*************************getProduct method is executed : "+ (end-start)+" ms *************************");
		
		return products;
		
	}

	@Override
	public Product getById(int id) {
		return productDao.findById(id)
				.orElseThrow(()->new ProductNotFoundException("product with id "+ id +" not found"));
	}

	@Override
	public Product getByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public Product addProduct(Product product) {
			productDao.save(product);
		return null;
	}

	@Override
	public Product deleteProduct(int id) {
		Product productToDelete=getById(id);
		productDao.delete(productToDelete);

		return productToDelete;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product productToUpdate=getById(id);
		productToUpdate.setPrice(product.getPrice());
		productDao.save(productToUpdate);
		return productToUpdate;
	}

}







