package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.RentType;
import com.codegym.casestudyfurama.repo.RentTypeRepository;
import com.codegym.casestudyfurama.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceIml implements RentTypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findALL() {
        return rentTypeRepository.findAll();
    }
}
