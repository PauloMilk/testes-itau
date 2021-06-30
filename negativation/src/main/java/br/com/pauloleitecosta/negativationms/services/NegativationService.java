package br.com.pauloleitecosta.negativationms.services;

import br.com.pauloleitecosta.negativationms.controllers.dto.NegativeDTO;

public interface NegativationService {

	void negativation(NegativeDTO dto);
	
	void negativeSerasa(NegativeDTO dto);
	
	void negativeSPC(NegativeDTO dto);
}
