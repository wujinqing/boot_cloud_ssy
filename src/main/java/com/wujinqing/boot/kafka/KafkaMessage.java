package com.wujinqing.boot.kafka;

import lombok.Data;

import java.util.Date;

@Data
public class KafkaMessage {
    private long id;
    private String username;
    private String password;
    private Date date;
}
