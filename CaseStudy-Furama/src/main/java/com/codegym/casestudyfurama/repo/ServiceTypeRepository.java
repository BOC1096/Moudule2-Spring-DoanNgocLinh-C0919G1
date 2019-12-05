package com.codegym.casestudyfurama.repo;

import com.codegym.casestudyfurama.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends JpaRepository<ServiceType, Long> {
    ServiceType findByNameServiceType(String string);

}
