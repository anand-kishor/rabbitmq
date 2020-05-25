package com.javasampleapproach.rabbitmq.subcriber;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Subcriber {

	@RabbitListener(queues="${jsa.rabbitmq.queue}")
    public void recievedMessage(byte[] log) {
		System.out.println("Recieved Message: " + new String(log));
    }
}