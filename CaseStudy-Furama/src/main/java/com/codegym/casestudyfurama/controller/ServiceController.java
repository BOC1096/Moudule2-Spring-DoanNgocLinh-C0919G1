package com.codegym.casestudyfurama.controller;

import com.codegym.casestudyfurama.entity.*;
import com.codegym.casestudyfurama.service.ContractService;
import com.codegym.casestudyfurama.service.Iml.ContractServiceIml;
import com.codegym.casestudyfurama.service.Iml.ServiceTypeSerIml;
import com.codegym.casestudyfurama.service.Iml.ServicerSerIml;
import com.codegym.casestudyfurama.service.Iml.UserServiceIml;
import com.codegym.casestudyfurama.service.ServiceSer;
import com.codegym.casestudyfurama.service.ServiceTypeSer;
import com.codegym.casestudyfurama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("like")
public class ServiceController {
    @Autowired
    private UserService userService = new UserServiceIml();

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
//            ServiceType serviceType1 = serviceTypeSer.getByName("Villa");
//            ServiceType serviceType2 = serviceTypeSer.getByName("House");
            Page<Service> services = serviceSer.findAll(pageable);
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
    public ModelAndView getBooking(@PathVariable("id") long id, Principal principal) {
        ModelAndView modelAndView = new ModelAndView("dichvu/book");
        Service service = serviceSer.findById(id);
        AppUser appUser = userService.getUser(principal.getName());
        Customer customer = appUser.getCustomer();
        modelAndView.addObject("services", service);
        Contract contract = new Contract();
        contract.setCustomer(customer);
        contract.setService(service);
        modelAndView.addObject("contract", contract);
        System.out.println(customer.getAddress());
        return modelAndView;
    }

    @GetMapping("/history")
    public ModelAndView getHistory(HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("dichvu/history");
        Cookie[] cookies = request.getCookies();
        List<Contract> contractList = new ArrayList<Contract>();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().contains("contract")) {
                Contract contract = new Contract();
                String[] cookieValue = cookies[i].getValue().split("_");
                contract.setId(Long.parseLong(cookieValue[0]));
                contract.setService(serviceSer.findByNameService(cookieValue[1]));
                contract.setDayStart(Date.valueOf(cookieValue[2]));
                contract.setDayEnd(Date.valueOf(cookieValue[3]));
                contractList.add(contract);
                modelAndView.addObject("contractList", contractList);
            }
        }
        if (contractList.isEmpty()) {
            modelAndView.addObject("message", "Not Found");
        }
        return modelAndView;
    }

    @PostMapping("/book")
    public String booking(@ModelAttribute("contract") Contract contract, RedirectAttributes redirectAttributes,
                          HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Principal principal) {
        contractService.addContract(contract);
        AppUser appUser = userService.getUser(principal.getName());
        List<Contract> contractList = contractService.findByCustomer(appUser.getCustomer());
        System.out.println(appUser.getCustomer().getAddress());
        System.out.println(contractList.size());
        for (Contract contract1 : contractList) {
            String cookieValue = contract1.getId() + "_" + contract1.getService().getNameService() + "_" +
                    contract1.getDayStart() + "_" + contract1.getDayEnd();
            Cookie cookie = new Cookie("contract" + contract1.getId(), cookieValue);
            cookie.setMaxAge(60 * 60);
            cookie.setPath("/history");
            httpServletResponse.addCookie(cookie);
        }
        redirectAttributes.addFlashAttribute("success", "Booking Successfully");
        return "redirect:/";
    }

    @ModelAttribute("like")
    public ListLike setupSession() {
        return new ListLike();
    }

    @GetMapping("/like/{id}")
    public String likeService(@PathVariable("id") long id, @ModelAttribute("like") ListLike serviceLike) {
        serviceLike.add(serviceSer.findById(id));
        return "redirect:/";
    }

    @GetMapping("/likeList")
    public String listLike() {
        return "dichvu/like";
    }
}
