package com.codegym.customermanagementrest.controller;

import com.codegym.customermanagementrest.entity.Customer;
import com.codegym.customermanagementrest.service.CustomerService;
import com.codegym.customermanagementrest.service.Iml.CustomerServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService = new CustomerServiceIml();

    @GetMapping
    public ResponseEntity<List<Customer>> listALLCustomer() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT); // May be return HttpStatus.NOT_FOUND
        } else {
            return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> getCus(@PathVariable("id") long id) {
        System.out.println("Fetching Customer with id" + id);
        Customer customer = customerService.getById(id);
        if (customer == null) {
            System.out.println("Customer with id: " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Customer>(customer, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createCus(@RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Create customer" + customer.getLastName());
        customerService.save(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCus(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Update customer with id " + id);
        Customer currentCustomer = customerService.getById(id);
        if (currentCustomer == null) {
            System.out.println("Customer with id: " + id + " not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            currentCustomer.setFirstName(customer.getFirstName());
            currentCustomer.setLastName(customer.getLastName());
            currentCustomer.setId(customer.getId());
            currentCustomer.setProvince(customer.getProvince());

            customerService.save(currentCustomer);
            return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCus(@PathVariable("id") long id) {
        System.out.println("Delete customer with id: " + id);
        Customer customer = customerService.getById(id);
        if (customer == null) {
            System.out.println("Customer want delete not found");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        } else {
            customerService.remove(id);
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
    }


}
