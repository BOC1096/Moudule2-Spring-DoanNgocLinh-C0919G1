package com.codegym.democustomermanager.service;

import com.codegym.democustomermanager.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CustomerService {
    Iterable<Customer> findAll();

    Optional<Customer> getById(long id);

    void save(Customer customer);

    void delete(long id);
}
