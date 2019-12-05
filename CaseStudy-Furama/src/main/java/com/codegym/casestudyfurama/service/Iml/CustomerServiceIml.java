package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.Customer;
import com.codegym.casestudyfurama.repo.CustomerRepository;
import com.codegym.casestudyfurama.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIml implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void addCus(Customer customer) {
        customerRepository.save(customer);
    }
}
