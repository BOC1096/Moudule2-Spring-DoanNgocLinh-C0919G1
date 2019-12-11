package com.codegym.casestudyfurama.controller;

import com.codegym.casestudyfurama.Validate.CustomerValidate;
import com.codegym.casestudyfurama.entity.Customer;
import com.codegym.casestudyfurama.entity.CustomerType;
import com.codegym.casestudyfurama.service.CustomerService;
import com.codegym.casestudyfurama.service.CustomerTypeService;
import com.codegym.casestudyfurama.service.Iml.CustomerServiceIml;
import com.codegym.casestudyfurama.service.Iml.CustomerTypeServiceIml;
import com.codegym.casestudyfurama.utils.WebUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService = new CustomerServiceIml();

    @Autowired
    private CustomerTypeService customerTypeService = new CustomerTypeServiceIml();

    @ModelAttribute("typeCustomer")
    public List<CustomerType> customerTypes() {
        return customerTypeService.findAll();
    }

    @GetMapping("/register")
    public ModelAndView formRegister() {
        return new ModelAndView("khachHang/register", "customer", new Customer());
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new CustomerValidate().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "khachhang/register";
        } else {
            try {
                customerService.addCus(customer);
                redirectAttributes.addFlashAttribute("success", "Create Customer Successfully");
            } catch (ConstraintViolationException ignored) {

            } finally {
                return "redirect:/";
            }
        }
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        return "khachHang/login";
    }

    @GetMapping("/403")
    public String accessDenied(Principal principal, Model model) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "khachHang/403";
    }

    @GetMapping("logoutSuccess")
    public String logout(Model model) {
        model.addAttribute("message", "logout Success");
        return "khachHang/login";
    }
}
