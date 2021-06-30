package br.com.pauloleitecosta.paymentms.controllers.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletoResponseDTO {
	
	private String cpf;
	private Double valor;
	private LocalDate vencimento;
	private String codigoBarras;
	private String linhaDigitavel;

}
