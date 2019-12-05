package com.codegym.customermanagerprovince.service.Iml;

import com.codegym.customermanagerprovince.entity.Customer;
import com.codegym.customermanagerprovince.entity.Province;
import com.codegym.customermanagerprovince.repo.CustomerRepository;
import com.codegym.customermanagerprovince.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceIml implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10, Sort.by("firstName"));
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), 5, Sort.by("firstName"));
        return customerRepository.findAllByFirstNameContaining(firstname, pageable);
    }

}
