package br.com.pauloleitecosta.paymentms.models.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_boleto")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_boleto")
	private Long id;

	@Column(name = "cd_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "cd_barras", nullable = false)
	private String codigoBarras;

	@Column(name = "vl_boleto", nullable = false)
	private Double valor;

	@Column(name = "cd_linha_digitavel", nullable = false)
	private String linhaDigitavel;

	@Column(name = "dt_vencimento", nullable = false)
	private LocalDate dataVencimento;

	@Column(name = "dt_cadastro", nullable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "ic_pagamento", nullable = false)
	private Boolean statusPagamento = false;

	public Boleto(String cpf, Double valor, LocalDate dataVencimento) {
		super();
		this.cpf = cpf;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
	}

}
