package br.com.pauloleitecosta.paymentms.controllers.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletoRequestDTO {
	
	@NotNull
	@CPF
	private String cpf;
	
	@DecimalMin("4.00")
	@DecimalMax("100000.00")
	private Double valor;
	
	private LocalDate vencimento;

}
