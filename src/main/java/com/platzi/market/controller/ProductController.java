package com.platzi.market.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.services.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/products")
public class ProductController {
	
    @Autowired
	private ProductService productService;
    
    /*
     *Utilizamos el ResponseEntity para mejorar las respuestas de mi Api
     *por medio de HttpStatus
     *(Teniendo en cuenta que hay metodos que devuelven un optional y otros que no) 
     */
    @GetMapping("/")
    @ApiOperation("Get All Supermarket Product")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){
    	//return productService.getAll();
    	return new ResponseEntity<>(productService.getAll(), HttpStatus.OK); 
    }
    
    @GetMapping("/{id}")
    @ApiOperation("Search a product with and ID")
    @ApiResponses({
    	@ApiResponse(code=200, message = "OK"),
    	@ApiResponse(code=404, message = "Product no  found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product",required = true , example = "7") @PathVariable("id") long productId){
    	return productService.getProduct(productId)
    			.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
    			.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") Long categoryId){
  	  return productService.getByCategory(categoryId)
  			  .map(category ->  new ResponseEntity<>(category, HttpStatus.OK))
  			  .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
  	  return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") Long productId){
    	if(productService.delete(productId)){
    		return new ResponseEntity<>(HttpStatus.OK);
    	} else {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    }
    
}
