package br.com.pauloleitecosta.communicationms.service.impl;

import org.springframework.stereotype.Service;

import br.com.pauloleitecosta.communicationms.amqp.AmqpProducer;
import br.com.pauloleitecosta.communicationms.dto.EmailQueueDTO;
import br.com.pauloleitecosta.communicationms.service.AmqpService;

@Service
public class AmqpServiceImpl implements AmqpService {

	private final AmqpProducer<EmailQueueDTO> amqpEmail;

	public AmqpServiceImpl(AmqpProducer<EmailQueueDTO> amqpEmail) {
		this.amqpEmail = amqpEmail;
	}

	@Override
	public void sendEmail(EmailQueueDTO message) {
		// TODO ADICIONAR LOG
		amqpEmail.producer(message);

	}

}
