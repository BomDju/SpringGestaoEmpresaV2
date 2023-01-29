package br.com.bomdju.SpringGestaoEmpresaV2.dto;

import java.time.LocalDate;

public class FuncionarioDto {

	private Integer id;
	private String nomeDoFuncionario;
	private String cpf;
	private Double salario;
	private LocalDate data;
	private Integer cargoId;
	private Integer setorId;
	private boolean ativo;

	public Integer getId() {
		return id;
	}

	public String getNomeDoFuncionario() {
		return nomeDoFuncionario;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public LocalDate getData() {
		return data;
	}

	public Integer getCargoId() {
		return cargoId;
	}

	public Integer getSetorId() {
		return setorId;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public void setNomeDoFuncionario(String nomeDoFuncionario) {
		this.nomeDoFuncionario = nomeDoFuncionario;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}
	
	public void setSetorId(Integer setorId) {
		this.setorId = setorId;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public FuncionarioDto() {

	}


}
