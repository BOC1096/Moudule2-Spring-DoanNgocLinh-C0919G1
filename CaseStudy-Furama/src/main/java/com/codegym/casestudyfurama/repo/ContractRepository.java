package com.codegym.casestudyfurama.repo;

import com.codegym.casestudyfurama.entity.Contract;
import com.codegym.casestudyfurama.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findByCustomer(Customer customer);

}
