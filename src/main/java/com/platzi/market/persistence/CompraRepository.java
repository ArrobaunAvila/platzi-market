package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.CompraCrudRepository;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.mapper.PurchaseMapper;

@Repository
public class CompraRepository implements PurchaseRepository{
  
	@Autowired
	CompraCrudRepository compraRepository;
	
	@Autowired
	PurchaseMapper mapper;
	
	@Override
	public List<Purchase> getAll() {
		return mapper.toPurchases((List<Compra>) compraRepository.findAll());
	}

	@Override
	public Optional<List<Purchase>> getByClient(String clientId) {
		return compraRepository.findByIdCliente(clientId)
				.map(compras -> mapper.toPurchases(compras));
	}

	@Override
	public Purchase save(Purchase purchase) {
	 Compra compra = mapper.toCompra(purchase);
	  compra.getProducto().forEach(producto -> producto.setCompra(compra));
	  return mapper.toPurchase(compraRepository.save(compra));
	}

}
