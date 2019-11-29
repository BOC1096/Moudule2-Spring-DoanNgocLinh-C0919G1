package com.codegym.customermanagementrest.service;

import com.codegym.customermanagementrest.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Customer getById(long id);

    void save(Customer customer);

    void remove(long id);
}
