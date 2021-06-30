package br.com.pauloleitecosta.negativationms.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauloleitecosta.negativationms.controllers.dto.NegativeDTO;
import br.com.pauloleitecosta.negativationms.services.NegativationService;

@RestController
@RequestMapping("negativations")
public class NegativationController {
	
	@Autowired
	private NegativationService negativationService;		
	
	@PostMapping()
	public void negative(@RequestBody @Valid NegativeDTO negativeDTO) {
		this.negativationService.negativation(negativeDTO);		
	}

}
