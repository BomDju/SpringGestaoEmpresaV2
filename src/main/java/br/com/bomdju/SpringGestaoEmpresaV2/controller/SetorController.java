package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.SetorDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.service.SetorService;

@Controller
@RequestMapping("setor")
public class SetorController {

	@Autowired
	private SetorService service;
	
	@GetMapping("/formularioSetor")
	public String formularioSetor() {
		return "/setor/formularioAdicionaSetor";
	}

	@PostMapping("/formularioAdicionaSetor")
	public String formularioNovoSetor(SetorDto dto, Model model) {
		service.save(dto);
		return homeSetor(model);

	}

	@GetMapping("/homeSetor")
	public String homeSetor(Model model) {
		List<Setor> setores = service.findAll();
		model.addAttribute("setores", setores);
		return "/setor/homeSetor";
	}
	
	@GetMapping("/deletaSetor/{id}")
	public String deletaSetor(SetorDto dto, Model model) {
		service.deletById(dto);
		return homeSetor(model); 
	}
	
	@PostMapping("/buscarSetor")
	public String buscarSetor(SetorDto dto, Model model){
		List<Setor> setores = service.buscaPorNome(dto);
		model.addAttribute("setores", setores);
		return "/setor/homeSetor";
	}
	
	@GetMapping("/formularioAtualizaSetor/{id}")
	public String atulizaSetor(SetorDto dto, Model model) {
		Setor setor =  service.findById(dto);
		model.addAttribute("setor", setor);
		return "/setor/formularioAtualizaSetor";
					   
	}
	
	@PostMapping("/atualizarSetor")
	public String atualizarSetor(SetorDto dto, Model model) {
		service.upadateSetor(dto);
		return homeSetor(model);
	}
}
