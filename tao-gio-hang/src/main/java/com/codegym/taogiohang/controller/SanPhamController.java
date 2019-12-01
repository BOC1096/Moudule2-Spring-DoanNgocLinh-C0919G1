package com.codegym.taogiohang.controller;

import com.codegym.taogiohang.entity.SanPham;
import com.codegym.taogiohang.service.GioHangService;
import com.codegym.taogiohang.service.Iml.GioHangServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SanPhamController {

    @Autowired
    public GioHangService gioHangService = new GioHangServiceIml();

    @GetMapping("/")
    public ModelAndView list() {
        List<SanPham> sanPhams = (List<SanPham>) gioHangService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("sanphams", sanPhams);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") long id) {
        SanPham sanPham = gioHangService.getById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("sanpham", sanPham);
        return modelAndView;
    }
}
