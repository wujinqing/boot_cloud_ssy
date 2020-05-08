package com.wujinqing.boot.controller;

import com.wujinqing.boot.kafka.KafkaMessage;
import com.wujinqing.boot.kafka.KafkaProducer;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.Date;

@RestController
@RequestMapping(value = "/kafka", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public KafkaMessage sendKafkaMessage(@RequestParam(name = "id") long id,
                                         @RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password)
    {
        System.out.println("sendKafkaMessage invoked!");

        KafkaMessage kafkaMessage = new KafkaMessage();

        kafkaMessage.setId(id);
        kafkaMessage.setUsername(username);
        kafkaMessage.setPassword(password);
        kafkaMessage.setDate(new Date());


        this.kafkaProducer.sendKafkaMessage(kafkaMessage);

        return kafkaMessage;
    }

    // curl -X POST -H "Content-Type:application/json" -d '{"id":5, "username":"李四", "password":"123"}' http://localhost:9090/kafka/message2
    @RequestMapping(value = "/message2", method = RequestMethod.POST)
    public KafkaMessage sendKafkaMessage2(KafkaMessage kafkaMessage)
    {
        kafkaMessage.setDate(new Date());

        this.kafkaProducer.sendKafkaMessage(kafkaMessage);

        return kafkaMessage;
    }
}
