package br.com.bomdju.SpringGestaoEmpresaV2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.FuncionarioDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
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
	// O setor e cargo estão comentados pra evitar erro, ainda não fiz o Crud do
	// cargo nem do setor

	public FuncionarioDto findById(FuncionarioDto dto) {
		Funcionario f = funcionarioRepository.findById(dto.getId()).get();
		dto.setNomeDoFuncionario(f.getNomeDoFuncionario());
		dto.setCpf(f.getCpf());
		dto.setData(f.getData());
		dto.setSalario(f.getSalario());
		dto.setCargo(f.getCargo());
		dto.setSetor(f.getSetor());
		dto.setAtivo(f.isAtivo());

		return dto;
	}

	public void setaAtivoFalse(FuncionarioDto dto) {
		Funcionario f = funcionarioRepository.findById(dto.getId()).get();
		f.setAtivo(false);
		funcionarioRepository.save(f);
	}

	public boolean save(FuncionarioDto dto) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		for (Funcionario funcionario : funcionarios) {
			if (funcionario.getCpf().equalsIgnoreCase(dto.getCpf())) {
				return false;
			}
		}
		Funcionario f = new Funcionario();
		f.setNomeDoFuncionario(dto.getNomeDoFuncionario());
		f.setCpf(dto.getCpf());
		f.setSalario(dto.getSalario());
		f.setData(dto.getData());
		f.setCargo(cargoRepository.findById(dto.getCargoId()).get());
		f.setSetor(setorRepository.findById(dto.getSetorId()).get());
		funcionarioRepository.save(f);
		return true;
	}

	public boolean update(FuncionarioDto dto) {
		Funcionario f = funcionarioRepository.findById(dto.getId()).get();

		if (dto.getCpf().equalsIgnoreCase(f.getCpf())) {

			f.setNomeDoFuncionario(dto.getNomeDoFuncionario());
			f.setData(dto.getData());
			f.setSalario(dto.getSalario());
			f.setCpf(dto.getCpf());
			f.setCargo(cargoRepository.findById(dto.getCargoId()).get());
			f.setSetor(setorRepository.findById(dto.getSetorId()).get());
			funcionarioRepository.save(f);
			return true;

		} else {
			List<Funcionario> funcionarios = funcionarioRepository.findAll();
			for (Funcionario funcionario : funcionarios) {
				if (funcionario.getCpf().equalsIgnoreCase(dto.getCpf())) {
					return false;
				}
			}
			f.setNomeDoFuncionario(dto.getNomeDoFuncionario());
			f.setCpf(dto.getCpf());
			f.setSalario(dto.getSalario());
			f.setData(dto.getData());
			f.setCargo(cargoRepository.findById(dto.getCargoId()).get());
			f.setSetor(setorRepository.findById(dto.getSetorId()).get());
			funcionarioRepository.save(f);
			return true;
		}

	}

	public List<Funcionario> findAllFuncionariosAtivo() {
		List<Funcionario> funcionarios = funcionarioRepository.findAllAtivo();
		return funcionarios;
	}

	public List<Funcionario> findAllInativo() {
		List<Funcionario> funcionarios = funcionarioRepository.findAllInativo();
		return funcionarios;
	}
	
	public void setFuncionarioAtivo(FuncionarioDto dto) {
		Funcionario f = funcionarioRepository.findById(dto.getId()).get();
		f.setAtivo(true);
		funcionarioRepository.save(f);
		dto.setAtivo(true);
		
	}

	public List<Funcionario> findAllByNome(FuncionarioDto dto) {
		List<Funcionario> funcionarios = funcionarioRepository.findByNomeDoFuncionario(dto.getNomeDoFuncionario());
		return funcionarios;
	}

	public List<Cargo> findAllCargo() {
		List<Cargo> cargos = cargoRepository.findAll();
		return cargos;
	}

	public List<Setor> findAllSetor() {
		List<Setor> setores = setorRepository.findAll();
		return setores;
	}

}
