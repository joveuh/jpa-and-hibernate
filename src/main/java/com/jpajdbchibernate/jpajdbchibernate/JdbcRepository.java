package com.jpajdbchibernate.jpajdbchibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY = 
            """
                INSERT INTO COURSE (id, name, author)
                values(1, 'SpringBoot', 'Uzair');
            """;

    public void insert(){
        jdbcTemplate.update(INSERT_QUERY);
    }
}
