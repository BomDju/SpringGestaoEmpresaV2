package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	public List<Funcionario> findByNomeDoFuncionario(String nomeDoFuncionario);

	@Query(value ="SELECT * FROM funcionarios f WHERE f.ativo = true", nativeQuery = true)
	public List<Funcionario> findAllAtivo();

	@Query(value ="SELECT * FROM funcionarios f WHERE f.ativo = false", nativeQuery = true)
	public List<Funcionario> findAllInativo();
}
