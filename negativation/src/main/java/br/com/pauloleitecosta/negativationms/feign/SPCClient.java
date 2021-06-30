package br.com.pauloleitecosta.negativationms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pauloleitecosta.negativationms.feign.dto.SPCNegativationRequestDTO;
import br.com.pauloleitecosta.negativationms.feign.dto.SPCNegativationResponseDTO;

@FeignClient(value = "spc", url = "https://reqbin.com/")
public interface SPCClient {

	@PostMapping("/echo/post/json")
	SPCNegativationResponseDTO negativeSPC(@RequestBody SPCNegativationRequestDTO dto);

}
