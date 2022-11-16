/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.platzi.market.domain.repository;

import com.platzi.market.domain.Product;
import java.util.List;
import java.util.Optional;



/**
 *
 * @author davila
 */
public interface ProductRepository {
	
    List<Product> getAll();
    
    Optional<List<Product>> getByCategory(Long categoryId);
    
    Optional<List<Product>> getScarseProduct(Long quantity);
    
    Optional<Product> getProduct(Long productId);
    
    Product save(Product product);
    
    void delete(Long productId);
    
}
