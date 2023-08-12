package org.example.services.impl;

import org.example.domain.enums.ProductCategory;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.dtos.ProductDto;
import org.example.repository.ProductRepository;
import org.example.repository.impl.ProductRepositoryImpl;
import org.example.services.ProductService;

import java.util.*;
import java.util.stream.Collectors;


public class ProductServiceImpl implements ProductService {

    List<ProductDto> products;
    List<OrderDto> orders;

    public ProductServiceImpl() {
        ProductRepository repo = new ProductRepositoryImpl();
        products = repo.products();
    }
    @Override
    public List<ProductDto> filterBooks() {
        return products.stream()
                .filter(product -> product.category().equals(ProductCategory.BOOKS))
                .filter(product -> product.price() > 100.00)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> filterProductsByCategory(ProductCategory category) {
        return orders.stream()
                .filter(e -> e.products().stream()
                        .anyMatch(prod -> prod.getCategory().getCategoryName().equals(category.getCategoryName())))
                .toList();
    }

    @Override
    public List<ProductDto> applyDiscountToToys() {
        return products.stream()
                .filter(product -> product.category() == ProductCategory.TOYS)
                .map(product -> {
                    double discountedPrice = product.price() * 0.10;
                    return new ProductDto(
                            product.id(),
                            product.name(),
                            product.category(),
                            product.price() - discountedPrice
                    );
                })
                .toList();
    }
    @Override
    public ProductDto getCheapestProductInCategory(ProductCategory category) {
        Optional<ProductDto> cheapestProduct = products.stream()
                .filter(product -> product.category() == category)
                .min(Comparator.comparingDouble(ProductDto::price));
        return cheapestProduct.orElse(null);
    }

    @Override
    public Map<String, Optional<ProductDto>> getMostExpensiveProduct() {
        Optional<ProductDto> mostExpensiveProduct = products.stream()
                .max(Comparator.comparingDouble(ProductDto::price));
        return Collections.singletonMap("mostExpensiveProduct", mostExpensiveProduct);
    }
}
