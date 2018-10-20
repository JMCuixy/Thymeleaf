package com.example.thymeleaf.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Endpoint(id = "my", enableByDefault = true) //设置 id，并选择是否默认开启
public class MyEndPoint {

    @ReadOperation
    public List<String> getPaths() {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        list.add("python");
        return list;
    }

    @ReadOperation
    public String get(@Selector String arg0) {
        return arg0;
    }


    @WriteOperation
    public String post() {
        return "post";
    }

    @DeleteOperation
    public Integer delete() {
        return 1;
    }
}
