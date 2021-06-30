package br.com.pauloleitecosta.negativationms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NegativationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NegativationApplication.class, args);
	}

}
