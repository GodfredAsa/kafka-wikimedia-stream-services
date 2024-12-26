### WIKIMEDIA KAFKA PRODUCER AND CONSUMER SUBSCRIPTION REAL WORLD PROJECT

[//]: # () This project contains two main project `kafka-producer-wikimedia`, `kafka-consumer-db` and `kafka-download` 
which is a download kafka from the web.
The producer draws data and the consumer stores the data in H2 data.
### KAFKA WITH WIKIMEDIA
1. `cd kafka-download` b4 running the codes below 
2. START ZOOKEEPER `bin/zookeeper-server-start.sh config/zookeeper.properties`
3. START KAFKA SERVER `bin/kafka-server-start.sh config/server.properties`
4. START THE SPRING BOOT APPLICATION 