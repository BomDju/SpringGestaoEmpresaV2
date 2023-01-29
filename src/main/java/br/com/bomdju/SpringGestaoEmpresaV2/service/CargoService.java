package br.com.bomdju.SpringGestaoEmpresaV2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.CargoDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;

	public List<Cargo> findAllAtivo() {
		List<Cargo> cargos = cargoRepository.findAllAtivo();
		return cargos;
	}

	public void deletById(CargoDto dto) {
		Cargo cargo =  cargoRepository.findById(dto.getId()).get();
		cargo.setAtivo(false);
		cargoRepository.save(cargo);
	}

	public void save(CargoDto dto ) {
		Cargo cargo = new Cargo();
		cargo.setNomeDoCargo(dto.getNomeDoCargo());
		cargoRepository.save(cargo);

	}

	public void upadateCargo(CargoDto dto) {
		Cargo cargo = cargoRepository.findById(dto.getId()).get();
		cargo.setNomeDoCargo(dto.getNomeDoCargo());
		cargoRepository.save(cargo);
	}
	
}
