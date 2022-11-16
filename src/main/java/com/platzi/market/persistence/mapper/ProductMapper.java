package com.platzi.market.persistence.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
  /*
   *Usamos la propiedad (uses) de @Mapper para indicarle el tipo de Mapeo que hara MapStruct
   *con la propiedad (Categoria categoria) en la clase Producto
   */
	@Mappings({
		@Mapping(source = "idProducto", target = "productId"),
		@Mapping(source = "idCategoria", target = "categoryId"),
		@Mapping(source = "nombre", target = "name"),
		@Mapping(source = "precioVenta", target = "price"),
		@Mapping(source = "cantidadStock", target = "stock"),
		@Mapping(source = "estado", target = "active"),
		@Mapping(source = "categoria",target = "category")
	})
	Product toProduct(Producto producto);
	
	List<Product> toProducts(List<Producto> productos);
	
	/* Con @InheritInverseConfiguration le indicamos que la conversion
	 * que hara sera inversa a toProducts y  ignorar la propiedad codigo de barras
	 */
	@InheritInverseConfiguration
	@Mapping(target = "codigoBarras", ignore = true)
	Producto toProducto(Product product);
	
}
