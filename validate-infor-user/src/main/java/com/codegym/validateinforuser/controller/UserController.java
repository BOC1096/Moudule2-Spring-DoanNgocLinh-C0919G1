package com.codegym.validateinforuser.controller;

import com.codegym.validateinforuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/user")
    public ModelAndView showForm() {
        return new ModelAndView("index", "user", new User());
    }

    @PostMapping("/validateUser")
    public ModelAndView validateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("result");
        }
    }
}
