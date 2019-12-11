package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.Service;
import com.codegym.casestudyfurama.entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@org.springframework.stereotype.Service
public interface ServiceSer {

    Page<Service> findAll(Pageable pageable);

    Page<Service> findByServiceType(ServiceType serviceType1, ServiceType serviceType2, Pageable pageable);

    Page<Service> findByPrice(double rentPrice, double rentPrice2, Pageable pageable);

    Service findById(long id);

    Service findByNameService(String nameService);
}
