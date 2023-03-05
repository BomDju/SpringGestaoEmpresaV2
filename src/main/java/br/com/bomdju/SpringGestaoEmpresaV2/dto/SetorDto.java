package br.com.bomdju.SpringGestaoEmpresaV2.dto;

import jakarta.validation.constraints.NotBlank;

public class SetorDto {

	private Integer id;
	@NotBlank
	private String nomeDoSetor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDoSetor() {
		return nomeDoSetor;
	}

	public void setNomeDoSetor(String nomeDoSetor) {
		this.nomeDoSetor = nomeDoSetor;
	}

}
