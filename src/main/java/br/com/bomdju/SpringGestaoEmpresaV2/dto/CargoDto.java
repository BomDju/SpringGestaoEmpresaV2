package br.com.bomdju.SpringGestaoEmpresaV2.dto;

import jakarta.validation.constraints.NotBlank;

public class CargoDto {

	private Integer id;
	
	@NotBlank
	private String nomeDoCargo;

	public String getNomeDoCargo() {
		return nomeDoCargo;
	}

	public void setNomeDoCargo(String nomeDoCargo) {
		this.nomeDoCargo = nomeDoCargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
