package com.restwebservice.RestWebService.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insertCourse(){
        String INSERT_QUERY = """
                insert into course (id, name, author)
                values(1, 'Learn AWS', 'Imran');
                """;
        springJdbcTemplate.update(INSERT_QUERY);
    }
}
