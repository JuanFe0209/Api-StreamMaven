package org.example.repository.impl;

import org.example.domain.enums.ProductCategory;
import org.example.domain.models.Product;
import org.example.mapping.dtos.ProductDto;
import org.example.mapping.mapper.ProductMapper;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
private List<Product> products;

    public ProductRepositoryImpl() {
        products = new ArrayList<>();
        products.add(new Product(1L, "La Odisea", ProductCategory.BOOKS, 80.00));
        products.add(new Product(2L, "100 años de soledad", ProductCategory.BOOKS, 60.00));
        products.add(new Product(3L, "Tetero", ProductCategory.BABIES, 12.99));
        products.add(new Product(4L, "Baby shoes", ProductCategory.BABIES, 22.99));
        products.add(new Product(5L, "Hotwheels", ProductCategory.TOYS, 9.99));
        products.add(new Product(6L, "Spiderman toy", ProductCategory.TOYS, 39.99));
    }
    @Override
    public List<ProductDto> products() {
        return ProductMapper.mapFrom(products);
    }
}
