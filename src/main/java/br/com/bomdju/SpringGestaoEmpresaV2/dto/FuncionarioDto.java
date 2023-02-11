package br.com.bomdju.SpringGestaoEmpresaV2.dto;

import java.time.LocalDate;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;

public class FuncionarioDto {

	private Integer id;
	private String nomeDoFuncionario;
	private String cpf;
	private Double salario;
	private LocalDate data;
	private Integer cargoId;
	private Integer setorId;

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

	public FuncionarioDto() {

	}

//	public FuncionarioDto(String nomeDoFuncionario, String cpf, Double salario, LocalDate data, Setor setor, Cargo cargo) {
//		this.nomeDoFuncionario = nomeDoFuncionario;
//		this.cpf = cpf;
//		this.salario =  salario;
//		this.data = data;
//		//this.cargo = cargo;
//		//this.setor = setor;
//	}

//	public FuncionarioDto(Funcionario funcionario) {
//		nomeDoFuncionario = funcionario.getNomeDoFuncionario();
//		cpf = funcionario.getCpf();
//		salario = funcionario.getSalario();
//		data = funcionario.getData();
//		// cargo = funcionario.getCargo();
//		// setor = funcionario.getSetor();
//
//	}

}
