package br.com.pauloleitecosta.negativationms.services.impl;

import org.springframework.stereotype.Service;

import br.com.pauloleitecosta.negativationms.controllers.dto.NegativeDTO;
import br.com.pauloleitecosta.negativationms.feign.SPCClient;
import br.com.pauloleitecosta.negativationms.feign.SerasaClient;
import br.com.pauloleitecosta.negativationms.feign.dto.SPCNegativationRequestDTO;
import br.com.pauloleitecosta.negativationms.feign.dto.SPCNegativationResponseDTO;
import br.com.pauloleitecosta.negativationms.feign.dto.SerasaNegativationRequestDTO;
import br.com.pauloleitecosta.negativationms.feign.dto.SerasaNegativationResponseDTO;
import br.com.pauloleitecosta.negativationms.services.NegativationService;

@Service
public class NegativationServiceImpl implements NegativationService {

	
	private final SerasaClient serasaClient;
	
	private final SPCClient spcclient;
		
	public NegativationServiceImpl(SerasaClient serasaClient, SPCClient spcClient) {		
		this.serasaClient = serasaClient;
		this.spcclient = spcClient;
	}

	@Override
	public void negativation(NegativeDTO dto) {
		if(dto.getEntity().equals("Serasa")) {
			this.negativeSerasa(dto);
		} else {
			this.negativeSPC(dto);
		}

	}

	@Override
	public void negativeSerasa(NegativeDTO dto) {
		// TODO TRATAR EXCEPTION DE FEIGNEXCEPTION
		SerasaNegativationRequestDTO serasaRequest = new SerasaNegativationRequestDTO(dto.getCpf());
		SerasaNegativationResponseDTO negativeSerasaResponse = this.serasaClient.negativeSerasa(serasaRequest);		
		System.out.println("Negativado SERASA: "+ negativeSerasaResponse.getSuccess());		
	}

	@Override
	public void negativeSPC(NegativeDTO dto) {
		// TODO TRATAR EXCEPTION DE FEIGNEXCEPTION
		SPCNegativationRequestDTO spcRequest = new SPCNegativationRequestDTO(dto.getCpf());
		SPCNegativationResponseDTO negativeSPCResponse = this.spcclient.negativeSPC(spcRequest);		
		System.out.println("Negativado SPC: "+ negativeSPCResponse.getSuccess());

	}

}
