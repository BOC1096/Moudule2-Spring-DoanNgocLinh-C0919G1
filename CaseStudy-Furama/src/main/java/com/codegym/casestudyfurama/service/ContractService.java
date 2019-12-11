package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.Contract;
import com.codegym.casestudyfurama.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {
    void addContract(Contract contract);

    Contract getById(long id);

    List<Contract> findByCustomer(Customer customer);
}
