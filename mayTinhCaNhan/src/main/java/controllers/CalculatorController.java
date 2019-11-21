package controllers;

import model.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping(value = "/calculator", params = "*")
    public ModelAndView nhan(@RequestParam("num1") float num1, @RequestParam("num2") float num2, Model model) {
        float result = Calculator.nhan(num1, num2);
        String kq = num1 + "X" + num2 + "=" + result;
        return new ModelAndView("home", "result", kq);
    }

    @PostMapping(value = "/calculator", params = "+")
    public ModelAndView cong(@RequestParam("num1") float num1, @RequestParam("num2") float num2, Model model) {
        float result = Calculator.cong(num1, num2);
        String kq = num1 + "+" + num2 + "=" + result;
        return new ModelAndView("home", "result", kq);
    }

    @PostMapping(value = "/calculator", params = "-")
    public ModelAndView tru(@RequestParam("num1") float num1, @RequestParam("num2") float num2, Model model) {
        float result = Calculator.tru(num1, num2);
        String kq = num1 + "-" + num2 + "=" + result;
        return new ModelAndView("home", "result", kq);
    }

    @PostMapping(value = "/calculator", params = "/")
    public ModelAndView chia(@RequestParam("num1") float num1, @RequestParam("num2") float num2, Model model) {
        try {
            float result = Calculator.chia(num1, num2);
            String kq = num1 + "/" + num2 + "=" + result;
            return new ModelAndView("home", "result", kq);
        } catch (Exception e) {
            return new ModelAndView("home", "result", e);
        }
    }

}
