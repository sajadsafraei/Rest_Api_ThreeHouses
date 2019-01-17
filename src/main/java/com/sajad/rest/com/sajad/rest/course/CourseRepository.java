package com.sajad.rest.com.sajad.rest.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    @RestResource(rel = "title-containes", path = "containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);

    @Query("select c from Course c")
    List<Course> findall();

}
