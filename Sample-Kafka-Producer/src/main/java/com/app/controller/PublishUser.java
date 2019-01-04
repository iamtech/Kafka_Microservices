package com.app.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UserDetails;

@RestController
@RequestMapping("producer")
public class PublishUser {
	
	@Autowired
    private KafkaTemplate<String, UserDetails> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {

        try {
			SendResult<String, UserDetails> metadata = kafkaTemplate.send(TOPIC, "KEY1",new UserDetails(name,"IT",25000L)).get();
			System.out.println("Name: "+name +" Partition: " +metadata.getRecordMetadata().partition()+" Offset:"+metadata.getRecordMetadata().offset());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return "Published successfully";
    }


}
