package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.Contract;
import org.springframework.stereotype.Service;

@Service
public interface ContractService {
    void addContract(Contract contract);
}
