package com.wujinqing.boot;

import com.wujinqing.boot.websocket.DefaultEchoService;
import com.wujinqing.boot.websocket.EchoService;
import com.wujinqing.boot.websocket.EchoWebSocketHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.PostConstruct;

/**
 * JDWP: Java Debug Wire Protocol Java调试协议
 */
@SpringBootApplication
@EnableWebSocket
public class MyApplication implements WebSocketConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(MyApplication.class);


    public static void main(String[] args) {

//        System.out.println(MyApplication.class.getClassLoader());
        SpringApplication.run(MyApplication.class, args);

//        SpringApplication springApplication = new SpringApplication(MyApplication.class);
//
//        springApplication.setBannerMode(Banner.Mode.OFF);
//
//        springApplication.run(args);
    }

    @PostConstruct
    public void myLog()
    {
        logger.trace("Trace Message.");
        logger.debug("Debug Message");
        logger.info("Info Message");
        logger.warn("Warn Message");
        logger.error("Error Message");
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler(), "/echo").withSockJS();
    }

    @Bean
    public EchoService echoService()
    {
        return new DefaultEchoService();
    }

    @Bean
    public EchoWebSocketHandler webSocketHandler()
    {
        return new EchoWebSocketHandler(echoService());
    }


}
