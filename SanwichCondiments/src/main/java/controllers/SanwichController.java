package controllers;

import model.Sandwich;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SanwichController {
    @GetMapping(value = "/home")
    public ModelAndView sandwich() {
        Sandwich sandwich = new Sandwich();
        sandwich.setCondiments((new String []{"Tomato","Lettuce"}));
        ModelAndView modelAndView = new ModelAndView("home", "command", sandwich);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("Condiment")Sandwich sandwich,
                          ModelMap model) {
        model.addAttribute("condiments", sandwich.getCondiments());
        return "result";
    }
    @ModelAttribute("CondimentList")
    public List<String> getCondiment() {
        List<String> condiment = new ArrayList<String>();
        condiment.add("Lettuce");
        condiment.add("Tomato");
        condiment.add("Mustard");
        condiment.add("Sprouts");
        return condiment;
    }
}
