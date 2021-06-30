package br.com.pauloleitecosta.negativationms.feign.dto;

public class SerasaNegativationRequestDTO {

	private String cpf;

	public SerasaNegativationRequestDTO(String cpf) {
		super();
		this.cpf = cpf;
	}

	public SerasaNegativationRequestDTO() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
