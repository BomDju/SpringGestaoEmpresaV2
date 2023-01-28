package br.com.bomdju.SpringGestaoEmpresaV2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	// Fazer tratamento de exeçao no caso do id inserido não existir ;)

	public Cargo findById(Integer id) {
		Cargo cargo = cargoRepository.findById(id).get();
		return cargo;
	}

	public void deletById(Integer id) {
		cargoRepository.deleteById(id);
	}

	public void save(String descricao) {
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);

	}

	public void upadateCargo(Integer id, String descricao) {
		Cargo c = cargoRepository.findById(id).get();
		c.setDescricao(descricao);
		cargoRepository.save(c);
	}
	
}
