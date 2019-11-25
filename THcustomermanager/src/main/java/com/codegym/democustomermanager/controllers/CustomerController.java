package com.codegym.democustomermanager.controllers;


import com.codegym.democustomermanager.entity.Customer;
import com.codegym.democustomermanager.service.CustomerService;
import com.codegym.democustomermanager.service.Iml.CustomerServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService = new CustomerServiceIml();

    @GetMapping("/")
    public ModelAndView home() {
        List<Customer> customers = (List<Customer>) customerService.findAll();
        return new ModelAndView("customer/list", "customers", customers);
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
            ModelAndView modelAndView = new ModelAndView("customer/delete");
            modelAndView.addObject("abc", customer);
           return modelAndView;
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
