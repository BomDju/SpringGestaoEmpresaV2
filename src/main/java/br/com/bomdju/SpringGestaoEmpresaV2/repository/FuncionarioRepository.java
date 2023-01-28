package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	public List<Funcionario> findByNomeDoFuncionario(String nomeDoFuncionario);

	@Query("SELECT f FROM Funcionario f WHERE f.nomeDoFuncionario = :nome AND f.salario >= :salario AND f.data = :data")
	public List<Funcionario> findByMaiorIgualDataContratacaoNomeSalario(String nome, Double salario, LocalDate data);

	@Query(value = "SELECT * FROM Funcionarios f WHERE f.data >= :data", nativeQuery = true)
	public List<Funcionario> findByMaiorIgualData(LocalDate data);

//	@Modifying
//	@Query("UPDADE f FROM Funcionario f SET f.nome = :nome, f.cpf = :cpf, f.salario = :salario, f.data = :data, f.cargo, f.setor "
//			+ "WHRER f.id = :idFuncionario AND f.cargo.id == :idCargo AND f.setor.id == :idSetor")
//	public void updadeByid(String nome, String cpf, Double salario, LocalDate data, Cargo cargo, Setor setor,
//			Integer idFuncionario, Integer idCargo, Integer idSetor);

//	@Modifying
//	@Query("UPDADE f FROM Funcionario f SET f.nome = :nome, f.cpf = :cpf, f.salario = :salario, f.data = :data, f.cargo, f.setor "
//			+ "WHRER f.id == :idFuncionario")
//	public void updadeById(String nome, String cpf, Double salario, LocalDate data, Cargo cargo, Setor setor,
//			Integer idFuncionario);

}
