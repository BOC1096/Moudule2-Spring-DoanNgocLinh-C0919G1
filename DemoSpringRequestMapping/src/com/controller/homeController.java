package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.portlet.ModelAndView;

@Controller

@RequestMapping(value = "/home")

public class homeController {

    @GetMapping(value = "/method0")
    public String method0() {
        return "method0";
    }

    @RequestMapping(value = {"/method1", "/method1/second"})
    public String method1() {
        return "method1";
    }

    @PostMapping(value = "/method2")
    public String method2() {
        return "method2";
    }

    @RequestMapping(value = "/method3", method = {RequestMethod.POST, RequestMethod.GET})
    public String method3() {
        return "method3";
    }

    @RequestMapping(value = "/method4", headers = "name=CodeGymDaNang", method = RequestMethod.POST)
    public String method4() {
        return "method4";
    }

    @PostMapping(value = "/method5", headers = {"name=CodeGymDaNang", "id=100"})
    public String method5() {
        return "method5";
    }

    @RequestMapping(value = "/method6", consumes = {"application/json"}, method = RequestMethod.POST)
    public String method6() {
        return "method6";
    }

    @RequestMapping(value = "/method7/{id}")
    public ModelAndView method7(@PathVariable(value = "id") int id) {
        ModelAndView modelAndView = new ModelAndView("method7", "id", id);
        return modelAndView;
    }

    @RequestMapping(value = "/method8/{id}/{name}")
    @ResponseBody
    public ModelAndView method8(@PathVariable("id") int id, @PathVariable("name") String name) {
        Object[] a = new Object[2];
        a[0] = id;
        a[1] = name;
        ModelAndView modelAndView = new ModelAndView("method8", "model", a);
        return modelAndView;
    }
}
