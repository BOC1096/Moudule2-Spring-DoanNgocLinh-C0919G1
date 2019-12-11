package com.codegym.casestudyfurama.service.Iml;

import com.codegym.casestudyfurama.entity.Review;
import com.codegym.casestudyfurama.repo.ReviewRepository;
import com.codegym.casestudyfurama.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewsServiceIml implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public Page<Review> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public void create(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getReview(long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        reviewRepository.deleteById(id);
    }
}
