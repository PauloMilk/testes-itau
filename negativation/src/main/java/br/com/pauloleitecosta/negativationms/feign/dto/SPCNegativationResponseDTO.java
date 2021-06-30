package br.com.pauloleitecosta.negativationms.feign.dto;

public class SPCNegativationResponseDTO {

	private Boolean success;

	public SPCNegativationResponseDTO() {

	}

	public SPCNegativationResponseDTO(Boolean success) {
		super();
		this.success = success;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
