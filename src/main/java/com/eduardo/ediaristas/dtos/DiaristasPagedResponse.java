package com.eduardo.ediaristas.dtos;

import com.eduardo.ediaristas.models.Diarista;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiaristasPagedResponse {

	private List<Diarista> diaristas;

	@JsonProperty("quantidade_diaristas")
	private Long quantidadeDiaristas;

}
