package kp.com.example.consumer.service;

import kp.com.example.model.Topic;
import kp.com.example.repository.TopicRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TopicListenerService {

    private final TopicRepository topicRepository;

    @Autowired
    public TopicListenerService(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @Value("${topic.name.consumer}")
    private String topicName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload){
      Topic myTopic = new Topic();
      myTopic.setMessage(payload.value());
      myTopic.setTopicName(topicName);
        log.info("Topic: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());
        topicRepository.save(myTopic);

    }

}