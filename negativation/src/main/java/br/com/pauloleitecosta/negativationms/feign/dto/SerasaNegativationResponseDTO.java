package br.com.pauloleitecosta.negativationms.feign.dto;

public class SerasaNegativationResponseDTO {

	private Boolean success;

	public SerasaNegativationResponseDTO() {

	}

	public SerasaNegativationResponseDTO(Boolean success) {
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
