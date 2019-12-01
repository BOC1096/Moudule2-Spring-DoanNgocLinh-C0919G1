package com.codegym.taogiohang.service.Iml;

import com.codegym.taogiohang.entity.SanPham;
import com.codegym.taogiohang.repo.GioHangRepository;
import com.codegym.taogiohang.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GioHangServiceIml implements GioHangService {
    @Autowired
    public GioHangRepository gioHangRepository;

    @Override
    public Iterable<SanPham> findAll() {
        return gioHangRepository.findAll();
    }

    @Override
    public SanPham getById(long id) {
        return gioHangRepository.findById(id).orElse(null);
    }
}
