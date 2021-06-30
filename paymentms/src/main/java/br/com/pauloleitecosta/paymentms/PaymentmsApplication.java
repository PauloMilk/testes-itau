package br.com.pauloleitecosta.paymentms;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PaymentmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentmsApplication.class, args);
	}
	
	@Bean
	Random random() {
		return new Random();
	}

}
