package br.com.pauloleitecosta.paymentms.controllers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;

import br.com.pauloleitecosta.paymentms.controllers.dto.ApiErrorResponse;
import br.com.pauloleitecosta.paymentms.controllers.dto.ErrorFormResponse;
import br.com.pauloleitecosta.paymentms.exceptions.BoletoJaPagoException;
import br.com.pauloleitecosta.paymentms.exceptions.BoletoNaoEncontradoException;

@RestControllerAdvice
public class PaymentControllerAdvice {

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorFormResponse> bindException(BindException ex) {
		List<ErrorFormResponse> errorFormDTOList = new ArrayList<>();
		List<FieldError> fieldErrorsList = ex.getBindingResult().getFieldErrors();
		fieldErrorsList.forEach(e -> {
			String message = e.getDefaultMessage();
			ErrorFormResponse error = ErrorFormResponse.builder().field(e.getField()).errorMessage(message).build();
			errorFormDTOList.add(error);
		});
		return errorFormDTOList;
	}
	
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse httpMessageNotReadableException(HttpMessageNotReadableException ex) {
        return ApiErrorResponse.builder().errors(Arrays.asList("O corpo da requisição não pode ser lido.")).build();
    }
    
    @ExceptionHandler(BoletoJaPagoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiErrorResponse boletoJaPagoException(BoletoJaPagoException ex) {
    	String message = "O boleto com a linha digitável: {0} já está pago!";
    	message = MessageFormat.format(message, ex.getMessage());
        return ApiErrorResponse.builder().errors(Arrays.asList(message)).build();
    }
    
    @ExceptionHandler(BoletoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void boletoNaoEncontradoException(BoletoNaoEncontradoException ex) {
    	
    }

}
