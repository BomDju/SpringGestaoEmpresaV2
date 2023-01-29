package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	@Query(value ="SELECT * FROM Cargos c WHERE c.ativo = true", nativeQuery = true)
	public List<Cargo> findAllAtivo();


}
