package br.com.bomdju.SpringGestaoEmpresaV2.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.FuncionarioRepository;

public class FuncinarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	
	@Autowired
	private CargoRepository cargoRepository;

	public Funcionario findById(Integer id) {
		Funcionario funcionario =funcionarioRepository.findById(id).get();
		return funcionario;
	}
	
	public void deletById(Integer id) {
		Funcionario funcionario =funcionarioRepository.findById(id).get();
		funcionarioRepository.deleteById(id);
		funcionarioRepository.
	}
	
	public Cargo save(String descricao) {
		Funcionario funcionario =funcionarioRepository.findById(id).get();
	}
	
	public Cargo upadate(Integer id, String descricao) {
	}

}
