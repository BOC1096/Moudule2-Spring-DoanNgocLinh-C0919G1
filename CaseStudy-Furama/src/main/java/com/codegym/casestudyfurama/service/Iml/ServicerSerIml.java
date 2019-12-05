package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.Service;
import com.codegym.casestudyfurama.entity.ServiceType;
import com.codegym.casestudyfurama.repo.ServiceReponsitory;
import com.codegym.casestudyfurama.service.ServiceSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public class ServicerSerIml implements ServiceSer {

    @Autowired
    ServiceReponsitory serviceReponsitory;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return serviceReponsitory.findAll(pageable);
    }

    @Override
    public Page<Service> findByServiceType(ServiceType serviceType1, ServiceType serviceType2, Pageable pageable) {
        return serviceReponsitory.findByServiceTypeOrServiceType(serviceType1, serviceType2, pageable);
    }

    @Override
    public Page<Service> findByPrice(double rentPrice, double rentPrice2, Pageable pageable) {
        return serviceReponsitory.findByRentPriceBetween(rentPrice, rentPrice2, pageable);
    }

    @Override
    public Service findById(long id) {
        return serviceReponsitory.findById(id).orElse(null);
    }
}
