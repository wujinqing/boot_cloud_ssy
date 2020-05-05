package com.wujinqing.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class JspController {
    @GetMapping("/jsp")
    public String jsp(Map<String, Object> model)
    {
        model.put("date", new Date());
        model.put("message", "hello world");

        return "result";
    }

    @GetMapping("/jspError")
    public String jspjspError(Map<String, Object> model)
    {
        throw new RuntimeException("jspError");
    }
}
