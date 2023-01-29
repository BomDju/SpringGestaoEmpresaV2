package br.com.bomdju.SpringGestaoEmpresaV2.orm;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "Cargo")
@Table(name = "cargos")
public class Cargo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeDoCargo;
	private boolean ativo = true;

	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public Cargo() {
	}

	public Integer getId() {
		return id;
	}

	public String getNomeDoCargo() {
		return nomeDoCargo;
	}

	public void setNomeDoCargo(String nomeDoCargo) {
		this.nomeDoCargo = nomeDoCargo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
