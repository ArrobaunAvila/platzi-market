package com.platzi.market.persistence.crud;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.platzi.market.persistence.entity.Compra;

public interface CompraCrudRepository extends CrudRepository<Compra, Long> {
   
	
	Optional<List<Compra>> findByIdCliente(String idCliente);
}
