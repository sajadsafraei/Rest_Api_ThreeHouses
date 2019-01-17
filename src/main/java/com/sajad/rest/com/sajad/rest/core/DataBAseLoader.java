package com.sajad.rest.com.sajad.rest.core;

import com.sajad.rest.com.sajad.rest.review.Review;
import com.sajad.rest.com.sajad.rest.course.Course;
import com.sajad.rest.com.sajad.rest.course.CourseRepository;
import com.sajad.rest.com.sajad.rest.user.User;
import com.sajad.rest.com.sajad.rest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DataBAseLoader implements ApplicationRunner {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public DataBAseLoader(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        String[] templates = {"Up and Runing with %s", "%S Basics of", "%s For Beginners", "Under the Hood %s"};
        String[] buzwords = {"Spring rest Data", "Java 9 ", "Scala", "Groovy"};

        List<User> students = Arrays.asList(
                new User("A", "A", "a", "1", new String[]{"ROLE_USER"}),
                new User("B", "B", "b", "1", new String[]{"ROLE_USER"}),
                new User("C", "C", "c", "1", new String[]{"ROLE_USER"}),
                new User("D", "D", "d", "1", new String[]{"ROLE_USER"}),
                new User("E", "E", "E", "1", new String[]{"ROLE_USER"})
        );

        userRepository.saveAll(students);
        userRepository.save(new User("Sajad", "sa", "sajad", "123", new String[]{"ROLE_USER", "ROLE_ADMIN"}));


        List<Course> courses = new ArrayList<>();

        IntStream.range(0, 100).forEach(i -> {
            String template = templates[i % templates.length];
            String buzzwor = buzwords[i % buzwords.length];
            String title = String.format(template, buzwords);
            Course c = new Course(title, "http://www.sajad.com");
            Review review = new Review(i % 5 + "", String.format("More %s Please", buzzwor));
            review.setReviwer(students.get(i % students.size()));
            c.addReview(review);
            courses.add(c);
        });

        courseRepository.saveAll(courses);
    }
}
