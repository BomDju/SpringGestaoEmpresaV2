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

	public void save(SetorDto dto) {
		Setor setor = new Setor();
		setor.setNomeDoSetor(dto.getNomeDoSetor());
		setorRepository.save(setor);

	}

	public void upadateSetor(SetorDto dto) {
		Setor setor = setorRepository.findById(dto.getId()).get();
		setor.setNomeDoSetor(dto.getNomeDoSetor());
		setorRepository.save(setor);
	}

	public List<Setor> buscaPorNome(SetorDto dto) {
		List<Setor> setores = setorRepository.findByNomeDoSetor(dto.getNomeDoSetor());
		return setores;

	}
	public Setor findById (SetorDto dto) {
		Setor setor = setorRepository.findById(dto.getId()).get();
		return setor; 
	}
}
