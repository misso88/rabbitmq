package com.test.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitmqListener {

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void recieveMessage(final Message message) {
        log.info("Message={}", message.toString());
    }
}
