package com.codegym.customphonevalidation.controller;

import com.codegym.customphonevalidation.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneNumberController {
    @GetMapping("/")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phonenumber", new PhoneNumber());
        return modelAndView;
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("phonenumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        } else {
            model.addAttribute("phonenumber", phoneNumber);
            return "result";
        }
    }
}

