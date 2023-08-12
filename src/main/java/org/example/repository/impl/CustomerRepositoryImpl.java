package org.example.repository.impl;
import org.example.domain.enums.ClientType;
import org.example.domain.models.Customer;
import org.example.mapping.dtos.CustomerDto;
import org.example.mapping.mapper.CustomerMapper;
import org.example.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
  private List <Customer> customers;

    public CustomerRepositoryImpl() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Client 1", ClientType.LEVEL_1));
        customers.add(new Customer(2L, "Client 2", ClientType.LEVEL_2));
        customers.add(new Customer(3L, "Client 3", ClientType.LEVEL_3));
    }
    @Override
    public List<CustomerDto> getAllCustomer() {
        return CustomerMapper.mapFrom(customers);
    }
}
