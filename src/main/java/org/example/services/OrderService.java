package org.example.services;

import org.example.domain.enums.ProductCategory;
import org.example.domain.models.Customer;
import org.example.mapping.dtos.OrderDto;
import org.example.mapping.dtos.ProductDto;
import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderDto> filterBabyProducts();
    List<ProductDto> productsClient2();
    List<OrderDto> displayMostRecentOrders();
    Double calculateGlobalSum();
    Double calculateGlobalPromedium();
    Map<Customer,List<OrderDto>> getOrderMapPerClient();
}

