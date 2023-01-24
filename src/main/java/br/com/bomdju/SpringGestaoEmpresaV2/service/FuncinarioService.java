package br.com.bomdju.SpringGestaoEmpresaV2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.FuncionarioDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.FuncionarioRepository;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.SetorRepository;

@Service
public class FuncinarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	@Autowired
	private SetorRepository setorRepository;

	// Fazer tratamento de exeçao no caso do id inserido não existir ;)

	public Funcionario findById(FuncionarioDto dto) {
		Funcionario funcionario = funcionarioRepository.findById(dto.getId()).get();
		return funcionario;
	}

	public void deletById(FuncionarioDto dto) {
		funcionarioRepository.deleteById(dto.getId());
	}

	
	public FuncionarioDto save (FuncionarioDto dto) {
		Funcionario f = new Funcionario();
		f.setNomeDoFuncionario(dto.getNomeDoFuncionario());
		f.setCpf(dto.getCpf());
		f.setSalario(Double.valueOf(dto.getSalario()));
		f.setData(dto.getData());
		f.setCargo(cargoRepository.findById(dto.getCargoId()).get());
		f.setSetor(setorRepository.findById(dto.getSetorId()).get());
 		funcionarioRepository.save(f);
		return dto;
	}
	
	public void upadate(FuncionarioDto dto) {

		Funcionario f = funcionarioRepository.findById(dto.getId()).get();

		f.setNomeDoFuncionario(dto.getNomeDoFuncionario());
		f.setData(dto.getData());
		f.setSalario(Double.valueOf(dto.getSalario()));
		f.setCpf(dto.getCpf());
		f.setCargo(cargoRepository.findById(dto.getCargoId()).get());
		f.setSetor(setorRepository.findById(dto.getSetorId()).get());
		funcionarioRepository.save(f);
	}
	
	public List<Funcionario> findAllFuncionarios() {
		List<Funcionario> funcionarios =funcionarioRepository.findAll();
		return funcionarios;
	}

}
