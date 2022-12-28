package br.com.bomdju.SpringGestaoEmpresaV2.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.repository.SetorRepository;

public class SetorService {

	@Autowired
	private SetorRepository setorRepository;

	// Fazer tratamento de exeçao no caso do id inserido não existir ;)

	public void save(String nome) {
		Setor setor = new Setor();
		setor.setNome(nome);
		setorRepository.save(setor);
	}

	public void update(String nome, Integer id) {
		setorRepository.updadeByid(nome, id);

	}

	public void deletByid(Integer id) {
		setorRepository.deleteById(id);
	}

	public Setor findById(Integer id) {
		Setor setor = setorRepository.findById(id).get();
		return setor;

	}
}
