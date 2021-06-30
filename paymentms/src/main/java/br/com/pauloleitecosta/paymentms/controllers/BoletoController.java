package br.com.pauloleitecosta.paymentms.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pauloleitecosta.paymentms.controllers.dto.BoletoPagamentoDTO;
import br.com.pauloleitecosta.paymentms.controllers.dto.BoletoRequestDTO;
import br.com.pauloleitecosta.paymentms.controllers.dto.BoletoResponseDTO;
import br.com.pauloleitecosta.paymentms.models.entities.Boleto;
import br.com.pauloleitecosta.paymentms.services.BoletoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("boletos")
@RequiredArgsConstructor
public class BoletoController {
	
	private final BoletoService service;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public BoletoResponseDTO emitirBoleto(@RequestBody @Valid BoletoRequestDTO dto) {		
		Boleto boleto = new Boleto(dto.getCpf(), dto.getValor(), dto.getVencimento());
		boleto = service.emitirBoleto(boleto);				
		return new BoletoResponseDTO(boleto.getCpf(), boleto.getValor(), boleto.getDataVencimento(), boleto.getCodigoBarras(), boleto.getLinhaDigitavel());
		
	}
	
	@PostMapping("pagamento")
	public void pagarBoleto(@RequestBody @Valid BoletoPagamentoDTO dto) {
		service.pagarBoleto(dto.getLinhaDigitavel());
	}
	
	
	@GetMapping()
	public Page<BoletoResponseDTO> obterBoletosPaginados(@PageableDefault Pageable pageable) {		
		Page<Boleto> boletoPage = service.obterBoletosPaginado(pageable);
		List<BoletoResponseDTO> boletoList = boletoPage.getContent().stream().map(x -> new BoletoResponseDTO(x.getCpf(), x.getValor(), x.getDataVencimento(), x.getCodigoBarras(), x.getLinhaDigitavel())).collect(Collectors.toList());
		return new PageImpl<BoletoResponseDTO>(boletoList,pageable, boletoPage.getTotalElements());
		
	}

}
