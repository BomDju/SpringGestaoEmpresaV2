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

	public List<Cargo> findAll() {
		List<Cargo> cargos = cargoRepository.findAll();
		return cargos;
	}

	public boolean deletById(CargoDto dto) {
		try {
			cargoRepository.deleteById(dto.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean save(CargoDto dto) {
		List<Cargo> cargos = cargoRepository.findAll();
		for (Cargo cargo : cargos) {
			if (dto.getNomeDoCargo().equalsIgnoreCase(cargo.getNomeDoCargo())) {
				return false;
			}
		}
		Cargo cargo = new Cargo();
		cargo.setNomeDoCargo(dto.getNomeDoCargo());
		cargoRepository.save(cargo);
		return true;
	}

	public boolean upadateCargo(CargoDto dto) {
		Cargo c = cargoRepository.findById(dto.getId()).get();

		if (c.getNomeDoCargo().equalsIgnoreCase(dto.getNomeDoCargo())) {
			c.setNomeDoCargo(dto.getNomeDoCargo());
			cargoRepository.save(c);
			return true;
		} else {
			List<Cargo> cargos = cargoRepository.findAll();
			for (Cargo cargo : cargos) {
				if (dto.getNomeDoCargo().equalsIgnoreCase(cargo.getNomeDoCargo())) {
					return false;
				}
			}
			c.setNomeDoCargo(dto.getNomeDoCargo());
			cargoRepository.save(c);
			return true;
		}

	}

	public List<Cargo> buscaPorNome(CargoDto dto) {
		List<Cargo> cargos = cargoRepository.findByNomeDoCargo(dto.getNomeDoCargo());
		return cargos;

	}

	public CargoDto findById(CargoDto dto) {
		Cargo cargo = cargoRepository.findById(dto.getId()).get();
		dto.setNomeDoCargo(cargo.getNomeDoCargo());
		return dto;
	}
}
