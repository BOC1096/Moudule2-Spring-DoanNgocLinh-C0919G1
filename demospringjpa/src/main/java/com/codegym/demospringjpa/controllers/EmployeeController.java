package com.codegym.demospringjpa.controllers;


import com.codegym.demospringjpa.entity.Employee;
import com.codegym.demospringjpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.Negative;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ModelAndView home() {
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        return new ModelAndView("Employee/home", "employees", employees);
    }

    @GetMapping("/create")
    public ModelAndView fromCreate() {
        Employee employee = new Employee();
        return new ModelAndView("Employee/create", "employee", employee);
    }

    @PostMapping("/create")
    public String save(Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Create Employee successfully!");
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView formUpdate(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.getById(id);
        return new ModelAndView("Employee/edit", "employee", employee);
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Update Employee successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("success", "Delete Employee successfully!");
        return "redirect:/";
    }

    @GetMapping("/search")
    public ModelAndView formSearch() {
        return new ModelAndView("Employee/search");
    }

    @PostMapping("/search")
    public ModelAndView search(@ModelAttribute("name") String name) {
        List<Employee> employee = employeeService.search(name);
        return new ModelAndView("Employee/view", "employee", employee);
    }
}