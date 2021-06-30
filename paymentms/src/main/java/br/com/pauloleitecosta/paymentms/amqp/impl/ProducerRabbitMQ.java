package br.com.pauloleitecosta.paymentms.amqp.impl;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.pauloleitecosta.paymentms.amqp.AmqpProducer;
import br.com.pauloleitecosta.paymentms.amqp.dto.BoletoQueueDTO;


@Component
public class ProducerRabbitMQ implements AmqpProducer<BoletoQueueDTO> {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.request.routing-key.producer}")
	private String queue;

	@Value("${spring.rabbitmq.request.exchange.producer}")
	private String exchange;

	@Override
	public void producer(BoletoQueueDTO message) {
		try {
			rabbitTemplate.convertAndSend(exchange, queue, message);
		} catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
	}
}
