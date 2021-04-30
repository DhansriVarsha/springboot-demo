package com.deloitte.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.business.ProductBusiness;
import com.deloitte.dto.ProductTO;
import com.deloitte.repositories.ProductRepository;
import com.deloitte.services.ProductService;

/**
 * Product service implement.
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
    private ProductBusiness productBusiness;

    @Override
    public Iterable<ProductTO> listAllProducts() {
        return productBusiness.listAllProducts();
    }

    @Override
    public ProductTO getProductById(Integer id) {
        return productBusiness.getProductById(id);
    }

    @Override
    public ProductTO saveProduct(ProductTO product) {
        return productBusiness.saveProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productBusiness.deleteProduct(id);
    }

}
