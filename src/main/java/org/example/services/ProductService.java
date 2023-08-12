package org.example.services;

import org.example.domain.enums.ProductCategory;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.dtos.ProductDto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> filterBooks();
    List<OrderDto> filterProductsByCategory(ProductCategory category);
    List<ProductDto> applyDiscountToToys();
    ProductDto getCheapestProductInCategory(ProductCategory category);
    Map<String, Optional<ProductDto>> getMostExpensiveProduct();
}

