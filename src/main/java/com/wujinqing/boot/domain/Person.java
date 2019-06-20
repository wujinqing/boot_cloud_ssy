package com.wujinqing.boot.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private int id;
    private String name;
    private Date birthday;
}
