package com.eduardo.ediaristas.services;

import com.eduardo.ediaristas.dtos.ViaCepResponse;
import com.eduardo.ediaristas.exceptions.CepInvalidoException;
import com.eduardo.ediaristas.exceptions.CepNaoEncontradoException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
	public ViaCepResponse buscarEnderecoPorCep(String cep) {
		var url = "https://viacep.com.br/ws/" + cep + "/json/";
		var clientHttp = new RestTemplate();
		ResponseEntity<ViaCepResponse> response;
		try {
			response = clientHttp.getForEntity(url, ViaCepResponse.class);

		} catch (HttpClientErrorException.BadRequest e) {
			throw new CepInvalidoException("CEP Inválido");
		}

		if (response.getBody().getCep() == null) {
			throw new CepNaoEncontradoException("CEP não encontrado");
		}

		return response.getBody();
	}

}
