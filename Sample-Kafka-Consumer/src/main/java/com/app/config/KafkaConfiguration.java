package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.app.model.UserDetails;

@Configuration
@EnableKafka
public class KafkaConfiguration {
	
	@Bean
	public ConsumerFactory<String, UserDetails> consumerFactory(){
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "Group_ID_1");
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(), new JsonDeserializer<>(UserDetails.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UserDetails> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, UserDetails> listenerFactory = new ConcurrentKafkaListenerContainerFactory<String, UserDetails>();
		listenerFactory.setConsumerFactory(consumerFactory());
		return listenerFactory;
	}

}
