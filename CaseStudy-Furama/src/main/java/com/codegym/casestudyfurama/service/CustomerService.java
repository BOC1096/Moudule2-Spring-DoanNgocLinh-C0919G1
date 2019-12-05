package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    void addCus(Customer customer);
}
