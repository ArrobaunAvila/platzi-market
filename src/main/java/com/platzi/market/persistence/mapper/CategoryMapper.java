package com.platzi.market.persistence.mapper;


import org.mapstruct.InheritInverseConfiguration;
/**
 *
 * @author davila
 */
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

@Mappings({
	@Mapping(source = "idCategoria",target = "categoryId"),
	@Mapping(source = "descripcion",target = "category"),
	@Mapping(source = "estado",target = "active"),
})	
Category toCategory(Categoria categoria);

/**
 * @InheritInverseConfiguration 
 * Le indica a mapStrup que la conversion es inversa al mappeo
 * */
@InheritInverseConfiguration 
@Mapping(target = "productos", ignore = true)
Categoria toCategoria(Category category);
    
}
