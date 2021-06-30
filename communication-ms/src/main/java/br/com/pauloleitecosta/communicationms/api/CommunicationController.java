package br.com.pauloleitecosta.communicationms.api;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauloleitecosta.communicationms.api.dto.EmailRequestDTO;
import br.com.pauloleitecosta.communicationms.dto.EmailQueueDTO;
import br.com.pauloleitecosta.communicationms.service.AmqpService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("communications")
@RequiredArgsConstructor
public class CommunicationController {

	private final AmqpService amqpService;

	@PostMapping("email")
	public void sendEmail(@RequestBody @Valid EmailRequestDTO requestEmailDTO) {
		System.out.println(requestEmailDTO.toString());
		amqpService.sendEmail(new EmailQueueDTO(requestEmailDTO.getEmail(), requestEmailDTO.getSubject(),
				requestEmailDTO.getMessage()));
	}
}
