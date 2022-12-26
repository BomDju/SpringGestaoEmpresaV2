package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

}
