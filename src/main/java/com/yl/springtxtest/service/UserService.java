package com.yl.springtxtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Liang.Yang5
 * @date 2018/9/12 13:09
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int update(String sql) {
        return jdbcTemplate.update(sql);
    }
}