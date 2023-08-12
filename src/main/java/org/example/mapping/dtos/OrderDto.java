package org.example.mapping.dtos;

import org.example.domain.models.Customer;
import org.example.domain.models.Product;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(Long id,
                       String status,
                       LocalDate orderDate,
                       LocalDate deliveryDate,
                       List<Product>products,
                       Customer customer){
}

