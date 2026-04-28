package com.spring_kafka.workingTest.kafka;

import com.spring_kafka.workingTest.payload.User;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaTopic_json", groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s"), user.toString());
    }
}
