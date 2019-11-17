package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/result")
    public ModelAndView serch(@RequestParam("vietnamese") String vietnamese) {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");
        String result = dic.get(vietnamese);
        Object[] a = new Object[2];
        a[0] = vietnamese;
        a[1] = result;
        return new ModelAndView("result", "result", a);
    }
}
