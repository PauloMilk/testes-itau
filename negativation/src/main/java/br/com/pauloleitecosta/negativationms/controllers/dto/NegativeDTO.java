package br.com.pauloleitecosta.negativationms.controllers.dto;

import javax.validation.constraints.NotNull;

public class NegativeDTO {

	@NotNull
	private String cpf;
	
	@NotNull
	private String entity;

	public NegativeDTO() {
	}

	public NegativeDTO(String cpf, String entity) {
		super();
		this.cpf = cpf;
		this.entity = entity;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

}
