package com.codegym.demospringjpa.service.Iml;

import com.codegym.demospringjpa.entity.Employee;
import com.codegym.demospringjpa.repository.EmployeeRepository;
import com.codegym.demospringjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(long id) {
        employeeRepository.deleteById(id);
    }


    public List<Employee> search(String name) {
        return employeeRepository.findByName(name);
    }
}
