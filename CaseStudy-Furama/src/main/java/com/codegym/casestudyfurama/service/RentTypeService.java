package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.RentType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentTypeService {
    List<RentType> findALL();
}
