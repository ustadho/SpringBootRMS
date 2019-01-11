package com.mitrais.bootcamp.springboot.dao;

import com.mitrais.bootcamp.springboot.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductDao extends PagingAndSortingRepository<Product, Long> {
}
