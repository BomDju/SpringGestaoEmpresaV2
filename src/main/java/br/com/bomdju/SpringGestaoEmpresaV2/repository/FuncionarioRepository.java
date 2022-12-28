package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
	@Modifying
	@Query("UPDADE f FROM Funcionario f SET f.nome = :nome, f.cpf = :cpf, f.salario = :salario, f.data = :data, f.cargo, f.setor "
			+ "WHRER f.id = :idFuncionario AND f.cargo.id == :idCargo AND f.setor.id == :idSetor")
	public void updadeByid(String nome, String cpf, Double salario, LocalDate data, Cargo cargo, Setor setor,
			Integer idFuncionario, Integer idCargo, Integer idSetor);
}
