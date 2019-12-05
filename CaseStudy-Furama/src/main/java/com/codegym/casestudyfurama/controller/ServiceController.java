package com.codegym.casestudyfurama.controller;

import com.codegym.casestudyfurama.entity.Contract;
import com.codegym.casestudyfurama.entity.Service;
import com.codegym.casestudyfurama.entity.ServiceType;
import com.codegym.casestudyfurama.service.ContractService;
import com.codegym.casestudyfurama.service.Iml.ContractServiceIml;
import com.codegym.casestudyfurama.service.Iml.ServiceTypeSerIml;
import com.codegym.casestudyfurama.service.Iml.ServicerSerIml;
import com.codegym.casestudyfurama.service.ServiceSer;
import com.codegym.casestudyfurama.service.ServiceTypeSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ServiceController {

    @Autowired
    private ServiceSer serviceSer = new ServicerSerIml();

    @Autowired
    private ServiceTypeSer serviceTypeSer = new ServiceTypeSerIml();

    @Autowired
    private ContractService contractService = new ContractServiceIml();

    @GetMapping("/")
    public ModelAndView home(@RequestParam(value = "pricefrom", required = false) Integer priceFrom, @RequestParam(value = "priceto", required = false) Integer priceTo, @PageableDefault(size = 6) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("dichvu/home");
        if (priceFrom == null || priceTo == null) {
            ServiceType serviceType1 = serviceTypeSer.getByName("Villa");
            ServiceType serviceType2 = serviceTypeSer.getByName("House");
            Page<Service> services = serviceSer.findByServiceType(serviceType1, serviceType2, pageable);
            modelAndView.addObject("services", services);
            return modelAndView;
        } else {
            Page<Service> services = serviceSer.findByPrice((double) priceFrom, (double) priceTo, pageable);
            if (services.isEmpty()) {
                modelAndView.addObject("services", services);
                modelAndView.addObject("message", "Not Found");
                return modelAndView;
            } else {
                modelAndView.addObject("services", services);
//            modelAndView.addObject("priceFrom", priceFrom);
//            modelAndView.addObject("priceTo", priceTo);
                return modelAndView;
            }
        }
    }



    @GetMapping("/{id}")
    public ModelAndView getService(@PathVariable("id") long id) {
        Service service = serviceSer.findById(id);
        return new ModelAndView("dichvu/view", "service", service);
    }

    @GetMapping("/book/{id}")
    public ModelAndView getBooking(@PathVariable("id") long id) {
        Service service = serviceSer.findById(id);
        ModelAndView modelAndView = new ModelAndView("dichvu/book");
        modelAndView.addObject("service", service);
        Contract contract = new Contract();
        contract.setService(service);
        modelAndView.addObject("contract", contract);
        return modelAndView;
    }

    @PostMapping("/book")
    public ModelAndView booking(@ModelAttribute("service") Service service, @ModelAttribute("contract") Contract contract) {
        contractService.addContract(contract);
        ModelAndView modelAndView = new ModelAndView("dichvu/book");
        modelAndView.addObject("message", "New Booking successfully");
        return modelAndView;
    }
}
