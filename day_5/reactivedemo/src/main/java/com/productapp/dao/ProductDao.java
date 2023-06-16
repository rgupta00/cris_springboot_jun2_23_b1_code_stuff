package com.productapp.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;

import com.productapp.dto.Product;

import reactor.core.publisher.Flux;

@Repository
public class ProductDao {


    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public List<Product> getProducts()  {
    	return IntStream.rangeClosed(1,	10)
    			.peek(ProductDao::sleepExecution)
    			.peek(i-> System.out.println("processing count "+i))
    			.mapToObj(i-> new Product(i, "product "+i))
    			.collect(Collectors.toList());
    	
        	
    }
    
    public Flux<Product> getProducttream()  {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Product(i, "product" + i));
    }


    public Flux<Product> getCustomerList()  {
        return Flux.range(1,50)
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Product(i, "product" + i));
    }
    
}
