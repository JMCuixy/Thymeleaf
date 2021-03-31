package com.example.thymeleaf.service.impl;

import com.example.thymeleaf.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/30 16:40
 * @Description:
 */
@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add() {
        int add = atomicInteger.addAndGet(new Random().nextInt(100000));
        int update = jdbcTemplate.update("insert into t_goods(id,name,sku,inventory) values (now(), now(), ?,?)", "apple-1000" + add, add);
        return update > 0;
    }
}
