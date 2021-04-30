package com.deloitte.business;

import com.deloitte.dto.ProductTO;

public interface ProductBusiness {

	Iterable<ProductTO> listAllProducts();

    ProductTO getProductById(Integer id);

    ProductTO saveProduct(ProductTO product);

    void deleteProduct(Integer id);

}
