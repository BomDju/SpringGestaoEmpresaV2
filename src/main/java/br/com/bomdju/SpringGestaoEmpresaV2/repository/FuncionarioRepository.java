package br.com.bomdju.SpringGestaoEmpresaV2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

}
