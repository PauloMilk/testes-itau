package br.com.pauloleitecosta.paymentms.controllers.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class ApiErrorResponse {
    private List<String> errors;

    public ApiErrorResponse(BindingResult bindingResult) {
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> this.errors.add(error.getDefaultMessage()));
    }

    public ApiErrorResponse(List<String> list) {
        this.errors = list;
    }

}