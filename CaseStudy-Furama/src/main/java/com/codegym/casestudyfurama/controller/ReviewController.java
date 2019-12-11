package com.codegym.casestudyfurama.controller;

import com.codegym.casestudyfurama.entity.AppUser;
import com.codegym.casestudyfurama.entity.Customer;
import com.codegym.casestudyfurama.entity.Review;
import com.codegym.casestudyfurama.service.Iml.ReviewsServiceIml;
import com.codegym.casestudyfurama.service.Iml.UserServiceIml;
import com.codegym.casestudyfurama.service.ReviewService;
import com.codegym.casestudyfurama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class ReviewController {

    @Autowired
    private UserService userService = new UserServiceIml();

    @Autowired
    private ReviewService reviewService = new ReviewsServiceIml();

    @GetMapping("/review")
    public ModelAndView allReview(@PageableDefault(size = 4) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("review/list");
        Page<Review> reviewPage = reviewService.findAll(pageable);
        if (reviewPage.isEmpty()) {
            modelAndView.addObject("reviews", reviewPage);
            modelAndView.addObject("message", "Not Found");
        } else {
            modelAndView.addObject("reviews", reviewPage);
        }
        return modelAndView;
    }

    @GetMapping("/write")
    public ModelAndView writeReviewForm(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("review/write");
        AppUser appUser = userService.getUser(principal.getName());
        Customer customer = appUser.getCustomer();
        Review review = new Review();
        review.setCustomer(customer);
        modelAndView.addObject("review", review);
        return modelAndView;
    }

    @PostMapping("/write")
    public String writeReview(@ModelAttribute("review") Review review, RedirectAttributes redirectAttributes) {
        reviewService.create(review);
        redirectAttributes.addFlashAttribute("success", "Review Success");
        return "redirect:/";
    }
}
