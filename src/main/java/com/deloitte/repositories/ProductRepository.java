package com.deloitte.repositories;

import org.springframework.data.repository.CrudRepository;

import com.deloitte.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
