package com.sajad.rest.com.sajad.rest.review;

import com.sajad.rest.com.sajad.rest.user.User;
import com.sajad.rest.com.sajad.rest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import sun.plugin.liveconnect.SecurityContextHelper;

@Component
@RepositoryEventHandler(Review.class)
public class ReviewEventHandler {

    private final UserRepository userRepository;

    @Autowired
    public ReviewEventHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @HandleBeforeCreate   ///this set who User send this review
    public void addReviewerLoggedInUser(Review review) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUserName(userName);
        review.setReviwer(user);
    }
}
