package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.CustomerType;
import com.codegym.casestudyfurama.repo.CustomerTypeRepository;
import com.codegym.casestudyfurama.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceIml implements CustomerTypeService {

    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
