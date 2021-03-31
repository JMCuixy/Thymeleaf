package com.example.thymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/30 16:54
 * @Description:
 */
@Service
public class TransactionService {

    @Autowired
    private PaService paService;
    @Autowired
    private GoodService goodService;

    public void test() {
        paService.add();
        goodService.add();
        int i = 0;
//        int j = 10 / i;
    }

}
