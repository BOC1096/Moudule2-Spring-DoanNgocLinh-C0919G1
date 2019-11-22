package com.codegym.product.controllers;

import com.codegym.product.model.Product;
import com.codegym.product.service.Iml.ProductServiceIml;
import com.codegym.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {

    private ProductService productService = new ProductServiceIml();


    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index", "products", productService.findAll());
    }

    @GetMapping("/add")
    public ModelAndView add() {
        return new ModelAndView("create", "product", new Product());
    }

    @PostMapping("/add")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random()) * 10000);
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "Add product success");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable int id) {
        return new ModelAndView("edit", "product", productService.findById(id));
    }

    @PostMapping("/edit")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        productService.save(product);
        redirectAttributes.addFlashAttribute("success", "update success");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        return new ModelAndView("delete", "product", productService.findById(id));
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id) {
        return new ModelAndView("view", "product", productService.findById(id));
    }
}
