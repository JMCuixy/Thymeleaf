package com.example.thymeleaf;

import com.example.thymeleaf.advisor.PlayService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: xiuyin.cui@joymo.tech
 * @Date: 2021/3/31 10:29
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdvisorTest {

    @Autowired
    private PlayService playService;

    @Test
    public void test() {
        playService.play("hello Advisor");
    }
}
