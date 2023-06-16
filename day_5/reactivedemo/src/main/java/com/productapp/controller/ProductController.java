package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.dto.Product;
import com.productapp.service.ProductService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService service;


    @GetMapping
    public List<Product> getAllProducts() {
        return service.loadAllProducts();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProductStream() {
        return service.loadAllProductStream();
    }
}