package com.wujinqing.boot.controller;

import com.wujinqing.boot.config.MyConfigBean;
import com.wujinqing.boot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MyController {
    @Value("${myConfig.myObject.myName}")
    private String myName;

    @Value("${myConfig.myObject.myAge}")
    private int myAge;

    @Autowired
    private MyConfigBean myConfigBean;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson()
    {
        Person p = new Person();


        p.setId(29);
        p.setName("张三");
        p.setBirthday(new Date());

        System.out.println(myName);
        System.out.println(myAge);

        System.out.println("=========");

        System.out.println(this.myConfigBean.getMyName());
        System.out.println(this.myConfigBean.getMyAge());
        return p;
    }
}
