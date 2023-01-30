package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	//Talvez ele seja usado
	public List<Cargo> findByNomeDoCargo(String nome);

}
