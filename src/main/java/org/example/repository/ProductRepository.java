package org.example.repository;

import org.example.mapping.dtos.ProductDto;

import java.util.List;

public interface ProductRepository {
    List<ProductDto> products();
}
