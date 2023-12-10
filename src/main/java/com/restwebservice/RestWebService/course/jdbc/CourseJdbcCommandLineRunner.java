package com.restwebservice.RestWebService.course.jdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    private final CourseJdbcRepository repository;
    CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository){
        this.repository = courseJdbcRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        repository.insertCourse();
    }
}
