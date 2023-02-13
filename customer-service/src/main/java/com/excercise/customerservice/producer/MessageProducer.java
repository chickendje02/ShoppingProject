package com.excercise.customerservice.producer;

import com.excercise.customerservice.utils.ObjectMapping;
import lombok.experimental.UtilityClass;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String KAFKA_TOPIC = "cart-topic";

    public <T> void sendMessage(T data, String key) {
        String message = ObjectMapping.writeObject(data);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(KAFKA_TOPIC,2, key, message);
        kafkaTemplate.send(producerRecord);
    }


}
