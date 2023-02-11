package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
