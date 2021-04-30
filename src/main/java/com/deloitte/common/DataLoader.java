package com.deloitte.common;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.deloitte.dto.ProductTO;
import com.deloitte.entities.Product;
import com.deloitte.repositories.ProductRepository;

@Component
public class DataLoader {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	Util util;
	
	@EventListener(ApplicationReadyEvent.class)
	public void appReady() {
		//this method will be called once the application is ready
		loadProduct();
	}
	
	public void loadProduct(){
		//inserting values into the database
		ProductTO productTo = new ProductTO();
		productTo.setName("Cake");
		productTo.setProductId("A1C35");
		productTo.setPrice(new BigDecimal("30"));
    	productRepository.save(util.map(productTo, Product.class));
    	
    	productTo.setName("Cup cakes");
		productTo.setProductId("3CSK12");
		productTo.setPrice(new BigDecimal("56"));
    	productRepository.save(util.map(productTo, Product.class));
    	
    	productTo.setName("Biscuits");
		productTo.setProductId("12KI");
		productTo.setPrice(new BigDecimal("12"));
    	productRepository.save(util.map(productTo, Product.class));
	}

}
