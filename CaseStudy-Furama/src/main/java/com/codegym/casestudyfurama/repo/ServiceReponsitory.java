package com.codegym.casestudyfurama.repo;

import com.codegym.casestudyfurama.entity.Service;
import com.codegym.casestudyfurama.entity.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceReponsitory extends JpaRepository<Service, Long> {
    @Query("select service from Service service where service.serviceType =?1 or service.serviceType =?2")
    Page<Service> findByServiceTypeOrServiceType(ServiceType serviceType1, ServiceType serviceType2, Pageable pageable);

    Page<Service> findByRentPriceBetween(double rentPrice, double rentPrice2, Pageable pageable);
}
