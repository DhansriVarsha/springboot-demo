package com.deloitte.services;

import com.deloitte.dto.ProductTO;;

public interface ProductService {

    Iterable<ProductTO> listAllProducts();

    ProductTO getProductById(Integer id);

    ProductTO saveProduct(ProductTO product);

    void deleteProduct(Integer id);

}
