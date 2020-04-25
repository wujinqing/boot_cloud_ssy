package com.wujinqing.boot.config;

import com.wujinqing.boot.initializer.MyInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public MyConfigBean myConfigBean(){
        return new MyConfigBean();
    }

    @Bean
    public MyInitializer myInitializer()
    {
        return new MyInitializer();
    }
}
