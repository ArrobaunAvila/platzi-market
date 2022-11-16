/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author davila
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Long>{
    
     /*
      *Podemos utilizar los QueryMethods O @Query(Pasando como parametro la consulta Query SQL)
      * (Para buenas practicas se utiliza los QueryMethods)
     */
    
    @Query(value="SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoria(Long idcategoria);
    
    List<Producto> findByIdCategoriaOrderByNombreAsc(long idcategoria);
    
    List<Producto> findAll();
    
    @Query(value="SELECT * FROM productos ORDER BY DESC", nativeQuery = true)
    List<Producto> getProductos();
    
    
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(long cantidadStock, boolean estado);
    
    
    
    
}
