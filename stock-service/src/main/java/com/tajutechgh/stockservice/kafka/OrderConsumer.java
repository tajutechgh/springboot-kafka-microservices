package com.tajutechgh.stockservice.kafka;

import com.tajutechgh.basedomains.dto.Order;
import com.tajutechgh.basedomains.dto.OrderEvent;
import com.tajutechgh.stockservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event){

        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));

        // save order event into the database
        Order order = event.getOrder();
        orderRepository.save(order);
    }
}