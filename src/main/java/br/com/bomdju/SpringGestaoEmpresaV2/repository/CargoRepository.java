package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	public List<Cargo> findByNomeDoCargo(String nomeDoCargo);
	
//	@Query(value = "SELECT * FROM cargos c WHERE c.nome_do_cargo = :nomeDoCargo", nativeQuery = true)
//	public List<Cargo> findNome(String nomeDoCargo);

}
	