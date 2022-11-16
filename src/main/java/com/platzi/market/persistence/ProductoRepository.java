/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davila
 */
@Repository
public class ProductoRepository implements ProductRepository {
	/* clase ProductoRepository que implementa la interfaz 
	 * ProductRepository La cual extiende de CrudRepository ---> JPA {Clase que nos permite usar los Query Method}
	 * */
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    
    /*
     * Vamos a orientar nuestro repository (ProductoRepository) con sus metodos a terminos de dominio {Product}
     * --------ProductMapper.--------
     * */
    @Autowired
    private ProductMapper mapper;
    
    @Override
    public List<Product> getAll(){
        List<Producto> productos =  (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    };
    
    @Override
	public Optional<List<Product>> getByCategory(Long categoryId) {
	 List<Producto> productos =   productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
     return Optional.of(mapper.toProducts(productos));
	}
    
    @Override
	public Optional<List<Product>> getScarseProduct(Long quantity) {
    	Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

    
    @Override
	public Optional<Product> getProduct(Long productId) {
		return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
		
	}
	
	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}

	@Override
	public void delete(Long productId) {
		productoCrudRepository.deleteById(productId);
	}
    
    
}
