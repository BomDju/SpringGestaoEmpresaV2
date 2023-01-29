package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;

@Repository
public interface SetorRepository extends CrudRepository<Setor, Integer> {

	@Query(value = "SELECT * FROM Setores s WHERE s.ativo = true", nativeQuery = true)
	public List<Setor> findAllAtivo();

}