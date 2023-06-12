package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

	public List<Setor> findByNomeDoSetor(String nomeDoSetor);
}