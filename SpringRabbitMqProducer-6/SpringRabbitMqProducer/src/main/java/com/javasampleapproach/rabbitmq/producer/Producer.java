package com.javasampleapproach.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Producer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	public void produce(Message message){
		
		/**
		 * void send(String exchange, String routingKey, Message message) throws AmqpException;
		 * routingKey is NOT need so we set it to an empty String.
		 * 
		 */
		amqpTemplate.send(exchange, "", message);
		System.out.println("Send msg = " + new String(message.getBody()));
	}
}