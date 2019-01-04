package com.app.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UserDetails;

@RestController
public class ConsumerListener {
	
	UserDetails messages = null;
	
	// containerFactory = "kafkaListenerContainerFactory" to select configuration for this listener
	// for fetching from specific partition of a Topic --> topicPartitions ={}
	@KafkaListener(id= "C01", groupId = "Group_ID_1", topicPartitions = { @TopicPartition(topic = "Kafka_Example", partitions = { "1" }) }, containerFactory = "kafkaListenerContainerFactory")
	//@KafkaListener(id= "C01", groupId = "Group_ID_1", topics = "Kafka_Example", containerFactory = "kafkaListenerContainerFactory")
	public UserDetails getMsgFromTopic(UserDetails data) {
		System.out.println(data.toString());
		messages = data;
		return messages;
	}
	
	@GetMapping("/consumeJsonMessage")
	public UserDetails consumeJsonMessage() {
		return messages;
	}

}
