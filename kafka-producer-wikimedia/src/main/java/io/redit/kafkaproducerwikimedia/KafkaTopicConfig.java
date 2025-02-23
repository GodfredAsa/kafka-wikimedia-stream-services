package io.redit.kafkaproducerwikimedia;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static io.redit.kafkaproducerwikimedia.KafkaConstants.*;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder
                .name(KAFKA_TOPIC)
                .partitions(PARTITIONS)
                .build();
    }
}
