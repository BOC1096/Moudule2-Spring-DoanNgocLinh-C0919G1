package com.codegym.customermanagerprovince.controllers;

import com.codegym.customermanagerprovince.entity.Customer;
import com.codegym.customermanagerprovince.entity.Province;
import com.codegym.customermanagerprovince.service.CustomerService;
import com.codegym.customermanagerprovince.service.Iml.CustomerServiceIml;
import com.codegym.customermanagerprovince.service.Iml.ProvinceServiceIml;
import com.codegym.customermanagerprovince.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;


@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService = new CustomerServiceIml();

    @Autowired
    private ProvinceService provinceService = new ProvinceServiceIml();

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/")
    public ModelAndView home(@RequestParam("s") Optional<String> s, @PageableDefault(size = 5)  Pageable pageable ) {
        Page<Customer> customers;
        if (s.isPresent()) {
            customers = customerService.findAllByFirstNameContaining(s.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        return new ModelAndView("customer/create", "customer", new Customer());
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer create successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEdit(@PathVariable("id") long id) {
        Customer customer = customerService.getById(id);
        if (customer != null) {
            return new ModelAndView("customer/edit", "customer", customer);
        } else {
            return new ModelAndView("/error:404");
        }
    }

    @PostMapping("/edit")
    public ModelAndView update(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/customer/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable("id") long id) {
        Customer customer = customerService.getById(id);
        if (customer != null) {
            return new ModelAndView("customer/delete", "customer", customer);
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.delete(customer.getId());
        return "redirect:/";
    }

}

