package br.com.bomdju.SpringGestaoEmpresaV2.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.FuncionarioRepository;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.SetorRepository;

public class FuncinarioService {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private SetorRepository setorRepository;
	
	
	//Fazer tratamento de exeçao no caso do id inserido não existir ;)

	public Funcionario findById(Integer id) {
		Funcionario funcionario =funcionarioRepository.findById(id).get();
		return funcionario;
	}
	
	public void deletById(Integer id) {
		funcionarioRepository.deleteById(id);
	}
	
	public void save(String nome, Double salario, LocalDate data, String cpf, Cargo cargo, Setor setor) {
		Funcionario f = new Funcionario();
		f.setNome(descricao);
		Funcionario funcionario = funcionarioRepository.findById(id).get();
	}
	
	public void upadate(String nome, String cpf, Double salario, LocalDate data, Cargo cargo, Setor setor, Integer id) {
		
		
	}
	
}
