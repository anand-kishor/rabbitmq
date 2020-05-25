package com.javasampleapproach.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javasampleapproach.rabbitmq.publisher.Publisher;

@SpringBootApplication
public class SpringRabbitMqPublisherApplication implements CommandLineRunner{

	@Autowired
	Publisher publisher;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqPublisherApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/**
		 *  1
		 */
		String systemErrorLog = "2014-03-05 10:58:51.1  INFO 45469 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/7.0.52";
		
		Message sysErrMsg = MessageBuilder.withBody(systemErrorLog.getBytes())
											.setDeliveryMode(MessageDeliveryMode.PERSISTENT)
											.build();
		
		// send to RabbitMQ
		publisher.doPublish(sysErrMsg);
		

		/**
		 *  message 2
		 *  
		 *  This message will be delivered to one queue: jsa.queue.logs.any-app-error
		 */
		String appErrorLog = "2017-10-10 10:57:51.112  ERROR java.lang.Exception: java.lang.Exception";
		
		Message appErrMsg = MessageBuilder.withBody(appErrorLog.getBytes())
											.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
											.build();
		
		// send to RabbitMQ
		publisher.doPublish(appErrMsg);
	}
}
