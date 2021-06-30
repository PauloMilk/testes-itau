package br.com.pauloleitecosta.paymentms.exceptions;

public class BoletoJaPagoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BoletoJaPagoException(String linhaDigitavel) {
		super(linhaDigitavel);
	}

}
