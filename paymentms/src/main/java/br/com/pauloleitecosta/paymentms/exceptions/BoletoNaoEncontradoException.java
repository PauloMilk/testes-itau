package br.com.pauloleitecosta.paymentms.exceptions;

public class BoletoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BoletoNaoEncontradoException(String linhaDigitavel) {
		super(linhaDigitavel);
	}

}
