package com.chtrembl.petstore.product.mapper;

import com.chtrembl.petstore.product.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productToProductDTO(com.chtrembl.petstore.product.entity.Product product);
    
    List<Product> productsToProductDTOs(List<com.chtrembl.petstore.product.entity.Product> products);
    
}
