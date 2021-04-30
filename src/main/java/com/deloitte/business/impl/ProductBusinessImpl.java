package com.deloitte.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deloitte.business.ProductBusiness;
import com.deloitte.common.Util;
import com.deloitte.dto.ProductTO;
import com.deloitte.entities.Product;
import com.deloitte.repositories.ProductRepository;

@Component
public class ProductBusinessImpl implements ProductBusiness{
	
	@Autowired
	private ProductRepository productRepository;
	
	 @Autowired
	 Util util;

    @Override
    public Iterable<ProductTO> listAllProducts() {
    	List<Product> list = new ArrayList<>();
    	productRepository.findAll().forEach(list::add);
    	return util.mapList(list, ProductTO.class);
    }

    @Override
    public ProductTO getProductById(Integer id) {
        return util.map(productRepository.findOne(id), ProductTO.class);
    }

    @Override
    public ProductTO saveProduct(ProductTO product) {
    	Product productEntity = util.map(product, Product.class);
    	Product saveEntity = productRepository.save(productEntity);
        return util.map(saveEntity, ProductTO.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.delete(id);
    }

}
