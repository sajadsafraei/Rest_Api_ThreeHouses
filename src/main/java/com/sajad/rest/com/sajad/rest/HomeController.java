package com.sajad.rest.com.sajad.rest;

import com.sajad.rest.com.sajad.rest.course.Course;
import com.sajad.rest.com.sajad.rest.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("a/v1/getAll")
    public List<Course> getAll() {
        List<Course> courseList = (List<Course>) courseRepository.findAll();
        return courseList;
    }

    @GetMapping("a/v1/getOne")
    public Course getOne() {
        Course course = courseRepository.findById(11L).get();
        return course;
    }

}
