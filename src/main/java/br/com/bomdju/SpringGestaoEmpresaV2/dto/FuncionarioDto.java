package br.com.bomdju.SpringGestaoEmpresaV2.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

public class FuncionarioDto {

	private Integer id;

	@NotBlank
	private String nomeDoFuncionario;

	@Length(min = 14, max = 14)
	@NotBlank
	private String cpf;

	@Digits(fraction = 2,integer = 6)
	@Positive
	@NotNull
	private Double salario;
	
	@Past
	private LocalDate data;
	
	@Digits(fraction = 0,integer = 5)
	@NotNull
	private Integer cargoId;

	@Digits(fraction = 0,integer = 5)
	@NotNull
	private Integer setorId;
	
	private Cargo cargo;
	
	private Setor setor;
	 
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

	public boolean isAtivo() {
		return ativo;
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Setor getSetor() {
		return setor;
	}
	
	public void setSetor(Setor setor) {
		this.setor = setor;
	}

}
