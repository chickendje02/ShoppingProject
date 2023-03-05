package com.excercise.cartservice.consumer;

import com.excercise.cartservice.model.kafka.Customer;
import com.excercise.cartservice.service.CartCommandService;
import com.excercise.cartservice.utils.MessageUtils;
import com.excercise.cartservice.utils.ObjectMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageConsumer {

    private static final String KAFKA_TOPIC = "cart-topic";

    @Autowired
    CartCommandService cartCommandService;

    @KafkaListener(topics = "quickstart", groupId = "group-quickstart-2")
    public void consumeSignUpCostumer(String message) {
        Customer customer = ObjectMapping.readValue(MessageUtils.decrypt(message), Customer.class);
        cartCommandService.addCart(customer.getId());
    }
}
