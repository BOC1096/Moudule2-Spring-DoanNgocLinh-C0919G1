package com.codegym.democustomermanager.repo;

import com.codegym.democustomermanager.entity.Customer;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
