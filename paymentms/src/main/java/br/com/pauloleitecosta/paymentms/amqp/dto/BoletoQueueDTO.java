package br.com.pauloleitecosta.paymentms.amqp.dto;

import java.time.LocalDate;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletoQueueDTO {
	
	private String cpf;

	private String codigoBarras;

	private String linhaDigitavel;

	private LocalDate dataVencimento;

}
