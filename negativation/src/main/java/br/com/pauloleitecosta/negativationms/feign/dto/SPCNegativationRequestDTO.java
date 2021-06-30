package br.com.pauloleitecosta.negativationms.feign.dto;

public class SPCNegativationRequestDTO {

	private String cpf;

	public SPCNegativationRequestDTO(String cpf) {
		super();
		this.cpf = cpf;
	}

	public SPCNegativationRequestDTO() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
