package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{
	
	@Query("UPDADE c FROM Cargo c SET c.descricao = :descricao WHRER c.id = :id")
	public void updadeByid(String nome, Integer id);

}
