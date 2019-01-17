package com.sajad.rest.com.sajad.rest.review;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;


public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {


    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or @reviewRepository.findById(#id).get().reviwer.userName==authentication.name")
    void deleteById(@Param("id") Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #review.reviwer?.userName==authentication.name")
    void delete(@Param("review") Review review);


}
