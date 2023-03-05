package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.SetorDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.service.SetorService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("setor")
public class SetorController {

	@Autowired
	private SetorService service;

	@GetMapping("/formularioSetor")
	public String formularioSetor(SetorDto dto) {
		return "/setor/formularioAdicionaSetor";
	}

	@PostMapping("/formularioAdicionaSetor")
	public String formularioNovoSetor(@Valid SetorDto dto, Model model, BindingResult result) {
		if ((result.hasErrors() || service.save(dto) == false)) {
			result.rejectValue("nomeDoSetor", "setor.erro", "Este setor já esta cadastrado");
			return formularioSetor(dto);
		}
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
		if (service.deletById(dto) == false) {
			Integer value= 1;
			model.addAttribute("value",value);
			return homeSetor(model);
		} else {
			return homeSetor(model);
		}
	}

	@PostMapping("/buscarSetor")
	public String buscarSetor(SetorDto dto, Model model) {
		List<Setor> setores = service.buscaPorNome(dto);
		model.addAttribute("setores", setores);
		return "/setor/homeSetor";
	}

	@GetMapping("/formularioAtualizaSetor/{id}")
	public String formularioAtualizaSetor(SetorDto dto, Model model) {
		SetorDto setorDto = service.findById(dto);
		model.addAttribute("setor", setorDto);
		return "/setor/formularioAtualizaSetor";

	}

	@PostMapping("/atualizarSetor")
	public String atualizarSetor(@Valid SetorDto dto, Model model, BindingResult result) {
		if (result.hasErrors() || service.upadateSetor(dto) == false) {
			result.rejectValue("nomeDoSetor", "setor.erro", "Este setor já esta cadastrado");
			return formularioAtualizaSetor(dto, model);
		}
		return homeSetor(model);
	}
}
