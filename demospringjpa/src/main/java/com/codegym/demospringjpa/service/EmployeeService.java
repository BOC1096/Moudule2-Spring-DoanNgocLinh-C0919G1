package com.codegym.demospringjpa.service;

import com.codegym.demospringjpa.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    Iterable<Employee> findAll();

    Optional<Employee> getById(long id);

    void save(Employee employee);

    void remove(long id);
    List<Employee> search(String name);
}
