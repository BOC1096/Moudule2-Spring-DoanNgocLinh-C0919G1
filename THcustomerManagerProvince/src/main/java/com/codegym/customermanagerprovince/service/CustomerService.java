package com.codegym.customermanagerprovince.service;

import com.codegym.customermanagerprovince.entity.Customer;
import com.codegym.customermanagerprovince.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

  Customer getById(long id);

    void save(Customer customer);

    void delete(long id);

    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
