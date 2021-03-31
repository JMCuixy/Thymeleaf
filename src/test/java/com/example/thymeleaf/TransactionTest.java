package com.example.thymeleaf;

import com.example.thymeleaf.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/30 16:36
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void test() {
        transactionService.test();
    }
}
