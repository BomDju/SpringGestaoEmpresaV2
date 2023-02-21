package br.com.bomdju.SpringGestaoEmpresaV2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.SetorDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.SetorRepository;

@Service
public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	public List<Setor> findAll() {
		List<Setor> setores = setorRepository.findAll();
		return setores;
	}

	public void deletById(SetorDto dto) {
		setorRepository.deleteById(dto.getId());
	}

	public boolean save(SetorDto dto) {
		List<Setor> setores = findAll();
		for (Setor setor : setores) {
			if (setor.getNomeDoSetor().equalsIgnoreCase(dto.getNomeDoSetor())) {
				return false;
			}
		}
		Setor s = new Setor();
		s.setNomeDoSetor(dto.getNomeDoSetor());
		setorRepository.save(s);
		return true;
	}

	public boolean upadateSetor(SetorDto dto) {
		Setor s = setorRepository.findById(dto.getId()).get();
		if(s.getNomeDoSetor().equalsIgnoreCase(dto.getNomeDoSetor())){
			s.setNomeDoSetor(dto.getNomeDoSetor());
			setorRepository.save(s);
			return true;
		}
		else {
			List<Setor> setores = findAll();
			for (Setor setor: setores) {
				if(setor.getNomeDoSetor().equals(dto.getNomeDoSetor())) {
					return false;
				}
				
			}
			s.setNomeDoSetor(dto.getNomeDoSetor());
			setorRepository.save(s);
			return true;
		}
	
	}

	public List<Setor> buscaPorNome(SetorDto dto) {
		List<Setor> setores = setorRepository.findByNomeDoSetor(dto.getNomeDoSetor());
		return setores;

	}

	public SetorDto findById(SetorDto dto) {
		Setor setor = setorRepository.findById(dto.getId()).get();
		dto.setNomeDoSetor(setor.getNomeDoSetor());
		return dto;
	}
}
