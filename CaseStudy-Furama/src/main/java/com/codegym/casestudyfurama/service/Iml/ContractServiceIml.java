package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.Contract;
import com.codegym.casestudyfurama.repo.ContractRepository;
import com.codegym.casestudyfurama.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceIml implements ContractService {

    @Autowired
    ContractRepository contractRepository;
    @Override
    public void addContract(Contract contract) {
        contractRepository.save(contract);
    }
}
