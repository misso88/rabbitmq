package com.test.rabbitmq.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitmqController {

    @Value("${spring.rabbitmq.template.exchange}")
    private String EXCHANGE_NAME;

    @Value("${spring.rabbitmq.template.routing-key}")
    private String ROUTING_KEY ;

    private final RabbitTemplate rabbitTemplate;

    @GetMapping("/test/rabbitmq")
    public String RabbitmqProducer() {
        String message = "RabbitMQ와 SpringBoot 실습 성공!";
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
        return message;
    }
}
