package com.app.config;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import com.app.model.UserDetails;

public class CustomPartitioner implements Partitioner{

	
	@Override
	public void configure(Map<String, ?> configs) {
		
	}

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		//Integer keyInt=Integer.parseInt(key.toString());
		UserDetails user = (UserDetails) value;
		System.out.println("Key:"+key);
		// If 'name' field in value is 'Jhon' then go to partition 0, rest to partition 1.
		if("Jhon".equals(user.getName())){
			return 0;
		}
		
		return 1;
	}

	@Override
	public void close() {
		
	}

	
}