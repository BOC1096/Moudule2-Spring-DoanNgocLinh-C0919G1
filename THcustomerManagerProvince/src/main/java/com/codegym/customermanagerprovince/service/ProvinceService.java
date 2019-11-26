package com.codegym.customermanagerprovince.service;

import com.codegym.customermanagerprovince.entity.Province;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProvinceService {
    Iterable<Province> findAll();

   Province findById(Long id);

    void save(Province province);

    void remove(Long id);

}

