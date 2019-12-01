package com.codegym.taogiohang.controller;

import com.codegym.taogiohang.entity.Item;
import com.codegym.taogiohang.entity.SanPham;
import com.codegym.taogiohang.service.GioHangService;
import com.codegym.taogiohang.service.Iml.GioHangServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("giohang")
//@RequestMapping("/giohang")
public class GioHangController {

    @Autowired
    private GioHangService gioHangService = new GioHangServiceIml();

    @ModelAttribute("giohang")
    public List<Item> gioHang() {
        return new ArrayList<Item>();
    }

    @GetMapping("/giohang")
    public ModelAndView list(@ModelAttribute("giohang") List<Item> giohang) {
//        List<SanPham> sanPhams = (List<SanPham>) gioHangService.findAll();
        ModelAndView modelAndView = new ModelAndView("show");
        double tongtien = tongtien(giohang);
        modelAndView.addObject("tongtien", tongtien);
        return modelAndView;
    }

    @GetMapping("/buy/{id}")
    public String buy(@ModelAttribute("giohang") List<Item> gioHang, @PathVariable("id") long id, RedirectAttributes redirectAttributes) {
        long index = isExist(id, gioHang);
        if (index == -1) {
            gioHang.add(new Item(gioHangService.getById(id), 1));
        } else {
            int soLuong = gioHang.get((int) index).getSoLuong() + 1;
            gioHang.get((int) index).setSoLuong(soLuong);
        }
        redirectAttributes.addFlashAttribute("success", "them thanh cong");
        return "redirect:../";
    }

    @GetMapping("/add/{id}")
    public String add(@ModelAttribute("giohang") List<Item> gioHang, @PathVariable("id") long id) {
        for (Item item : gioHang) {
            if (item.getSanPham().getId() == id) {
                item.setSoLuong(item.getSoLuong() + 1);
            }
        }
        return "redirect:../giohang/";
    }

    @GetMapping("/delete/{id}")
    public String xoa(@ModelAttribute("giohang") List<Item> giohang, @PathVariable("id") long id) {
        for (Item item : giohang) {
            if (item.getSanPham().getId() == id) {
                if (item.getSoLuong() == 1) {
                    giohang.remove(item);
                } else {
                    item.setSoLuong(item.getSoLuong() - 1);
                }
            }
        }
        return "redirect:../giohang/";
    }

    private double tongtien(List<Item> cart) {
        double result = 0;
        for (Item item :
                cart) {
            result += item.getSanPham().getGia() * item.getSoLuong();
        }
        return result;
    }

    private long isExist(long id, List<Item> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getSanPham().getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
