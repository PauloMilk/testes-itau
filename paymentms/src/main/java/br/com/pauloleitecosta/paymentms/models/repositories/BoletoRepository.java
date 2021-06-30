package br.com.pauloleitecosta.paymentms.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pauloleitecosta.paymentms.models.entities.Boleto;


public interface BoletoRepository extends JpaRepository<Boleto, Long>{

	Optional<Boleto> findByLinhaDigitavel(String linhaDigitavel);

}
