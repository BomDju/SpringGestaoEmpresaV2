package br.com.bomdju.SpringGestaoEmpresaV2.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;

public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public Cargo findById(Integer id) {
		Cargo cargo = cargoRepository.findById(id).get();
		return cargo;
	}
	
	public void deletById(Integer id) {
		cargoRepository.deleteById(id);
	}
	
	public Cargo save(String descricao) {
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		return cargo;
	}
	
	public Cargo upadate(Integer id, String descricao) {
		Cargo cargo = cargoRepository.findById(id).get();
		cargo.setDescricao(descricao);
		return cargo;
	}
}
	