package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.CustomerType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerTypeService {
    List<CustomerType> findAll();

}
