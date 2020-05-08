package com.wujinqing.boot.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaCosumer {
    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void obtainMessage(ConsumerRecord<String, String> consumerRecord)
    {
        System.out.println("obtainMessage invoked!");


        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        String value = consumerRecord.value();
        int partition = consumerRecord.partition();
        long timestamp = consumerRecord.timestamp();

        System.out.println("topic: " + topic);
        System.out.println("key: " + key);
        System.out.println("value: " + value);
        System.out.println("partition: " + partition);
        System.out.println("timestamp: " + timestamp);

        System.out.println("==============");










    }
}
