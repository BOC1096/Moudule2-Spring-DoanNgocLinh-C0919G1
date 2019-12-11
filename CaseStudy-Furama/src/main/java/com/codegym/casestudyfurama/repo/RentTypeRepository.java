package com.codegym.casestudyfurama.repo;

import com.codegym.casestudyfurama.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {

}
