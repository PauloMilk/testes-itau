package br.com.pauloleitecosta.communicationms.service;

import br.com.pauloleitecosta.communicationms.dto.EmailQueueDTO;

public interface AmqpService {

	void sendEmail(EmailQueueDTO message);	
}
