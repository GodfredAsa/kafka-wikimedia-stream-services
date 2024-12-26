package io.redit.kafkaconsumerdb;

import io.redit.kafkaconsumerdb.entity.Wikimedia;
import io.redit.kafkaconsumerdb.entity.WikimediaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    // No @Autowire bcos the bean KafkaDatabaseConsumer contains only one parameterised constructor
    private WikimediaRepository wikimediaRepository;

    public KafkaDatabaseConsumer(WikimediaRepository wikimediaRepository) {
        this.wikimediaRepository = wikimediaRepository;
    }

    @KafkaListener(topics = "wikimedia_recent_change", groupId = "myGroup")
    public void consume(String eventMessage) {
        LOGGER.info("Received Event Message: {}", eventMessage);

        StringBuilder sbf = new StringBuilder();
        Wikimedia wikimedia = new Wikimedia(eventMessage);
        wikimediaRepository.save(wikimedia);
    }
}
