package com.example.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@JdbcTest
@Transactional
public class JdbcTemplateTest {
    @Autowired private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void init() {
        jdbcTemplate.execute("create table if not exists hello (name varchar(255) primary key,age int)");
    }

    @Test
    void insertQuery() {
        jdbcTemplate.update("insert into hello values (?,?)","jsshin",2);
        jdbcTemplate.update("insert into hello values (?,?)","jsshin2",3);

        Long count = jdbcTemplate.queryForObject("select count(*) from hello", Long.class);
        assertThat(count).isEqualTo(2);
    }


}
