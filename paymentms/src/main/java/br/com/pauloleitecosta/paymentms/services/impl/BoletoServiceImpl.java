package br.com.pauloleitecosta.paymentms.services.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.pauloleitecosta.paymentms.amqp.AmqpProducer;
import br.com.pauloleitecosta.paymentms.amqp.dto.BoletoQueueDTO;
import br.com.pauloleitecosta.paymentms.exceptions.BoletoJaPagoException;
import br.com.pauloleitecosta.paymentms.exceptions.BoletoNaoEncontradoException;
import br.com.pauloleitecosta.paymentms.models.entities.Boleto;
import br.com.pauloleitecosta.paymentms.models.repositories.BoletoRepository;
import br.com.pauloleitecosta.paymentms.services.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService {

	private final BoletoRepository repository;

	private final AmqpProducer<BoletoQueueDTO> amqp;

	private final Random random;

	public BoletoServiceImpl(BoletoRepository repository, AmqpProducer<BoletoQueueDTO> amqp, Random random) {
		super();
		this.repository = repository;
		this.amqp = amqp;
		this.random = random;
	}

	@Override
	public Boleto emitirBoleto(Boleto boleto) {
		boleto.setCodigoBarras(gerarStringAleatoria());
		boleto.setLinhaDigitavel(gerarStringAleatoria());
		Boleto boletoSalvo = this.repository.save(boleto);
		BoletoQueueDTO boletoQueueDTO = new BoletoQueueDTO(boleto.getCpf(), boleto.getCodigoBarras(),
				boleto.getLinhaDigitavel(), boleto.getDataVencimento());
		this.amqp.producer(boletoQueueDTO);
		return boletoSalvo;
	}

	@Override
	public void pagarBoleto(String linhaDigitavel) {
		Optional<Boleto> boletoOptional = repository.findByLinhaDigitavel(linhaDigitavel);
		if (boletoOptional.isEmpty()) {
			throw new BoletoNaoEncontradoException(linhaDigitavel);
		}
		Boleto boleto = boletoOptional.get();
		if (boleto.getStatusPagamento()) {
			throw new BoletoJaPagoException(linhaDigitavel);
		}

		boleto.setStatusPagamento(true);
		repository.save(boleto);
	}
	
	@Override
	public Page<Boleto> obterBoletosPaginado(Pageable pageable) {
		return repository.findAll(pageable);
	}


	private String gerarStringAleatoria() {
		String aleatorio = this.random.nextLong() + "." + this.random.nextFloat() + "." + this.random.nextFloat();
		if (aleatorio.length() > 255) {
			aleatorio = aleatorio.substring(0, 244);
		}
		return aleatorio.replace("-", "");
	}

	
}
