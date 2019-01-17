package com.example.thymeleaf;

import com.example.thymeleaf.observer.EventSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/17 12:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ObserverTest {

    @Autowired
    private EventSource eventSource;

    @Test
    public void test() {
        eventSource.sendMsg();
    }
}
