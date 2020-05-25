package com.javasampleapproach.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
	
	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(byte[] log) {
        System.out.println("Recieved Message: " + new String(log));
    }
}