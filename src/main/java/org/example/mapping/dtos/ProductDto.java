package org.example.mapping.dtos;

import org.example.domain.enums.ProductCategory;

public record ProductDto (Long id,
                         String name,
                         ProductCategory category,
                         double price){

}

