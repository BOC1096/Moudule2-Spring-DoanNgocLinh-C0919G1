package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.ServiceType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServiceTypeSer {
    ServiceType getByName(String string);

    List<ServiceType> findAll();
}
