package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;

public interface SetorRepository extends CrudRepository<Setor, Integer> {

	@Query("UPDADE s FROM Setor s SET s.nome = :nome WHRER s.id = :id")
	public void updadeByid(String nome, Integer id);
}
