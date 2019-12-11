package com.codegym.casestudyfurama.service;

import com.codegym.casestudyfurama.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    Page<Review> findAll(Pageable pageable);

    void create(Review review);

    Review getReview(long id);

    void delete(long id);
}
