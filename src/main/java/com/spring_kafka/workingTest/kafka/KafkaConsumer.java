package com.spring_kafka.workingTest.kafka;

import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics= "javaTopic", groupId = "myGroup")
    public void consume(String message){
        LOGGER.info(String.format("Message Recevied -> %s", message));

    }
}
