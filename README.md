# Kafka_Microservices - sample Producer and Consumer Microservices (Using Custom Partition)
  
<b>Start Zookeeper Server</b>  
<i>bin\windows\zookeeper-server-start.bat config\zookeeper.properties</i>  

<b>Start Kafka Server</b>  
<i>bin\windows\kafka-server-start.bat config\server.properties</i>  

<b>Create Topic:</b>  
<i>bin/windows/kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic Kafka_Example </i>
  
<b>Alter Topic</b>  
<i>bin/windows/kafka-topics.bat --alter --zookeeper localhost:2181 --partitions 2 --topic Kafka_Example</i>
