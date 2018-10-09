package com.example.thymeleaf.dto;

public class UserDto {

    /**
     *
     */
    private String uuid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄 1、男 2、女
     */
    private Integer age;
    /**
     * 用户详细地址
     */
    private String address;

    public UserDto(){

    }

    public UserDto(String uuid, String name, Integer age, String address) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
