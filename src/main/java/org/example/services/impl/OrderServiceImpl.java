package org.example.services.impl;

import org.example.domain.enums.ClientType;
import org.example.domain.enums.ProductCategory;
import org.example.domain.models.Customer;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.dtos.ProductDto;
import org.example.repository.OrderRepository;
import org.example.repository.ProductRepository;
import org.example.repository.impl.OrderRepositoryImpl;
import org.example.repository.impl.ProductRepositoryImpl;
import org.example.services.OrderService;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    List<OrderDto> orders;
    static List<ProductDto> products;

    private OrderRepository repository;

    public OrderServiceImpl() {
        OrderRepository repo = new OrderRepositoryImpl();
        ProductRepository rep = new ProductRepositoryImpl();
        products = rep.products();
        orders = repo.getAllOrders();
    }


    private List<OrderDto> getMostRecentOrders(int n) {
        return orders.stream()
                .sorted(Comparator.comparing(OrderDto::orderDate).reversed())
                .limit(3)
                .toList();
    }
    @Override
    public List<OrderDto> filterBabyProducts() {
        return orders.stream()
                .filter(order -> order.products().stream()
                        .anyMatch(Product -> Product.getCategory().equals(ProductCategory.BABIES)))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> productsClient2() {
        return orders.stream()
                .filter(e -> e.customer().getTier() == ClientType.LEVEL_2)
                .filter(e -> e.orderDate().isAfter(LocalDate.of(2021, 2, 9)))
                .filter(e -> e.orderDate().isBefore(LocalDate.of(2021, 3, 11)))
                .flatMap(e -> e.products().stream())
                .distinct()
                .map(product -> new ProductDto(product.getId(), product.getName(),product.getCategory(),product.getPrice()))
                .toList();
    }


    @Override
    public List<OrderDto> displayMostRecentOrders() {
        System.out.println("----- 3 Most Recent Orders -----");
        List<OrderDto> mostRecentOrders = getMostRecentOrders(3);
        for (OrderDto order : mostRecentOrders) {
            System.out.println(order);
        }
        System.out.println();
        return null;
    }

    @Override
    public Double calculateGlobalSum() {
        return orders
                .stream()
                .filter(o -> o.orderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.orderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(o -> o.products().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();
    }

    @Override
    public Double calculateGlobalPromedium() {
        return orders
                .stream()
                .filter(o -> o.orderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .flatMap(o -> o.products().stream())
                .mapToDouble(p -> p.getPrice())
                .average().getAsDouble();
    }

    @Override
    public Map<Customer, List<OrderDto>> getOrderMapPerClient() {
        Map<Customer, List<OrderDto>> result = orders.stream()
                .collect(Collectors.groupingBy(orderDto -> orderDto.customer()));
        return result;
    }
}
