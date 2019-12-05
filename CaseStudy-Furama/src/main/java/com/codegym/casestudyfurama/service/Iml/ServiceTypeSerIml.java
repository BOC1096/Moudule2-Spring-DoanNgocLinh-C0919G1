package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.ServiceType;
import com.codegym.casestudyfurama.repo.ServiceTypeRepository;
import com.codegym.casestudyfurama.service.ServiceTypeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeSerIml implements ServiceTypeSer {

    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    @Override
    public ServiceType getByName(String string) {
        return serviceTypeRepository.findByNameServiceType(string);
    }

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
