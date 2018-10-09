package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.UserDto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/list")
    public String listUser(Model model) {
        List<UserDto> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userList.add(new UserDto(UUID.randomUUID().toString().replace("-", ""), "张三" + i, 1, "中国北京"));
        }
        model.addAttribute("users", userList);
        return "user/list";
    }
}
