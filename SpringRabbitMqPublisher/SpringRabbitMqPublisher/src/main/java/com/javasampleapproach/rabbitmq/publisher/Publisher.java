package com.javasampleapproach.rabbitmq.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${jsa.rabbitmq.exchange}")
	private String exchange;
	
	public void doPublish(Message msg){
		amqpTemplate.send(exchange, "",msg);
		System.out.println("Send msg = " + new String(msg.getBody()));
	}
}