package br.com.bomdju.SpringGestaoEmpresaV2.orm;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "setores")
public class Setor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeDoSetor;
	private boolean ativo = true;

	@OneToMany(mappedBy = "setor")
	private List<Funcionario> funcionario;

	public Setor() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nomeDoSetor;
	}

	public void setNome(String nome) {
		this.nomeDoSetor = nome;
	}
	 public boolean isAtivo() {
		return ativo;
	}
}
