package br.com.pauloleitecosta.negativationms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pauloleitecosta.negativationms.feign.dto.SerasaNegativationRequestDTO;
import br.com.pauloleitecosta.negativationms.feign.dto.SerasaNegativationResponseDTO;

@FeignClient(value="serasa", url = "https://reqbin.com/")
public interface SerasaClient {
	
	@PostMapping("/echo/post/json")
	SerasaNegativationResponseDTO negativeSerasa(@RequestBody SerasaNegativationRequestDTO dto);

}
