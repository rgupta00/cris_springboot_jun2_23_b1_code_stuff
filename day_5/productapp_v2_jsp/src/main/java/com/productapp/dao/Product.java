package com.productapp.dao;

import java.math.BigDecimal;
//Using hibeante -> ORM framewrok 
//Build on top of jdbc

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.productapp.validation.ProductTypeValidation;

@Entity
@Table(name = "product_table")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Integer id;

	@NotEmpty(message = "{product.name.absent}")
	@Column(name = "product_name")
	private String name;

	@NotNull(message = "product price must not be null")
	@Range(max = 200000, min = 10, message = "{account.price.invalid}")
	@Column(name = "product_price")
	private BigDecimal price;

	//@ProductTypeValidation
	private String productType;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product(String name, BigDecimal price, String productType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.productType = productType;
	}

	public Product() {
	}

}
