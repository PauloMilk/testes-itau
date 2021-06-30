package br.com.pauloleitecosta.paymentms.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.pauloleitecosta.paymentms.models.entities.Boleto;


public interface BoletoService {
	
	Boleto emitirBoleto(Boleto boleto);

	void pagarBoleto(String linhaDigitavel);

	Page<Boleto> obterBoletosPaginado(Pageable pageable);	

}
