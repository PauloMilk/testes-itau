package br.com.pauloleitecosta.paymentms.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorFormResponse {
	private String field;
	private String errorMessage;
}