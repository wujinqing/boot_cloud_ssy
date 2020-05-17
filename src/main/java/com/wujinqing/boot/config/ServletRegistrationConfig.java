package com.wujinqing.boot.config;

import com.wujinqing.boot.filter.MyFilter;
import com.wujinqing.boot.servlet.MyServlet2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletRegistrationConfig {
    @Bean
    public ServletRegistrationBean<MyServlet2> myServletRegistrationBean()
    {
        ServletRegistrationBean<MyServlet2> servletRegistrationBean = new ServletRegistrationBean<>();

        servletRegistrationBean.addUrlMappings("/myServlet2");
        servletRegistrationBean.setServlet(new MyServlet2());

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean()
    {
        FilterRegistrationBean<MyFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();

        filterFilterRegistrationBean.addUrlPatterns("/myServlet2/*");
        filterFilterRegistrationBean.setFilter(new MyFilter());


        return filterFilterRegistrationBean;
    }
}
