package br.com.pauloleitecosta.communicationms.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailRequestDTO {
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String subject;
	
	@NotNull
	private String message;

}
