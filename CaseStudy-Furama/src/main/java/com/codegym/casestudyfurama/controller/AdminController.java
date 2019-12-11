package com.codegym.casestudyfurama.controller;

import com.codegym.casestudyfurama.entity.RentType;
import com.codegym.casestudyfurama.entity.ServiceType;
import com.codegym.casestudyfurama.service.Iml.RentTypeServiceIml;
import com.codegym.casestudyfurama.service.Iml.ServiceTypeSerIml;
import com.codegym.casestudyfurama.service.Iml.ServicerSerIml;
import com.codegym.casestudyfurama.service.RentTypeService;
import com.codegym.casestudyfurama.service.ServiceSer;
import com.codegym.casestudyfurama.service.ServiceTypeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    ServiceSer serviceSer = new ServicerSerIml();

    @Autowired
    private ServiceTypeSer serviceTypeSer = new ServiceTypeSerIml();

    @Autowired
    RentTypeService rentTypeService = new RentTypeServiceIml();

    @ModelAttribute("serviceType")
    public List<ServiceType> getService() {
        return serviceTypeSer.findAll();
    }

    @ModelAttribute("rentType")
    public List<RentType> getRent() {
        return rentTypeService.findALL();
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        return new ModelAndView("admin/admin");
    }

}
