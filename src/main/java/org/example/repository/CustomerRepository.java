package org.example.repository;

import org.example.mapping.dtos.CustomerDto;

import java.util.List;

public interface CustomerRepository {
    List<CustomerDto> getAllCustomer();
}
