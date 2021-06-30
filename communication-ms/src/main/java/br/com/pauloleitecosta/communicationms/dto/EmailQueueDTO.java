package br.com.pauloleitecosta.communicationms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmailQueueDTO {
	
	private String email;
		
	private String subject;
		
	private String message;

}
