package io.redit.kafkaproducerwikimedia;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import static io.redit.kafkaproducerwikimedia.KafkaConstants.KAFKA_TOPIC;

@Service
public class WikimediaChangesProducer {
    public static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final NewTopic topic;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate, NewTopic topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage() throws InterruptedException {
//        kafkaTemplate.send(topic, message);

        // READ REAL TIME STREAM DATA USE EVENT SOURCE
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, KAFKA_TOPIC);

        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        EventSource.Builder builder =  new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();
        eventSource.start();
        TimeUnit.MINUTES.sleep(10);

    }
}
