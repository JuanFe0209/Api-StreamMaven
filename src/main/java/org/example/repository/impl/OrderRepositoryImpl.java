package org.example.repository.impl;

import org.example.domain.models.Customer;
import org.example.domain.models.Order;
import org.example.domain.models.Product;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.mapper.CustomerMapper;
import org.example.mapping.mapper.OrderMapper;
import org.example.mapping.mapper.ProductMapper;
import org.example.repository.CustomerRepository;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
        private List<Order> orders;
        private List<Product> products;
        private List<Customer> customers;
        public OrderRepositoryImpl() {
            CustomerRepositoryImpl customerRepo = new CustomerRepositoryImpl();
            ProductRepositoryImpl productRepo = new ProductRepositoryImpl();
            customers = CustomerMapper.mapFromDto(customerRepo.getAllCustomer());
            products = ProductMapper.mapFromDto(productRepo.products());

            orders = new ArrayList<>();

            orders.add(new Order(1L, "Pending", LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 5), Arrays.asList(products.get(0), products.get(3)), customers.get(0)));
            orders.add(new Order(2L, "Sent", LocalDate.of(2022, 3, 2), LocalDate.of(2022, 3, 10), Arrays.asList(products.get(1), products.get(4)), customers.get(1)));
            orders.add(new Order(3L, "Pending", LocalDate.of(2021, 3, 15), LocalDate.of(2022, 3, 15), Arrays.asList(products.get(2), products.get(3), products.get(4)), customers.get(2)));
            orders.add(new Order(4L, "Sent", LocalDate.of(2021, 2, 18), LocalDate.of(2021, 2, 20), Arrays.asList(products.get(2), products.get(3), products.get(4)), customers.get(2)));
            orders.add(new Order(5L, "Sent", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 10), Arrays.asList(products.get(0), products.get(5)), customers.get(1)));
        }

        @Override
        public List<OrderDto> getAllOrders() {
            return OrderMapper.mapFrom(orders);
        }
    }


