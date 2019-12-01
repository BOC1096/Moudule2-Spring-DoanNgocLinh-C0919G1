package com.codegym.taogiohang.service;

import com.codegym.taogiohang.entity.SanPham;
import org.springframework.stereotype.Service;


@Service
public interface GioHangService {
    Iterable<SanPham> findAll();

    SanPham getById(long id);

}
