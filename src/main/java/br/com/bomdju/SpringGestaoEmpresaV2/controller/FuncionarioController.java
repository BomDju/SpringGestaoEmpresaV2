package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.FuncionarioDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.service.FuncinarioService;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncinarioService service;

	@GetMapping("/formularioFuncionario")
	public String formulario() {
		return "funcionario/formularioFuncionario";
	}

	@GetMapping("/homeFuncionario")
	public String homeFuncionario(Model model) {
		List<Funcionario> funcionarios = service.findAllFuncionarios();
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/homeFuncionario";
	}

	@GetMapping("/visualizarFuncionario")
	public String vizualizarFuncionario() {
		return "funcionario/visualizarFuncionario";
	}

	@PostMapping("/cadastrarFuncionario")
	public String cadastrarNovoFuncionario(FuncionarioDto dto, Model model) {
		service.save(dto);
		return homeFuncionario(model);
	}
	
	@PostMapping("/buscaFuncionario")
	public String buscaFuncionario(FuncionarioDto dto, Model model) {
		Funcionario funcionarios = service.findById(dto); 
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/homeFuncionario";
	}
	
	@GetMapping(value= "/deletarFuncionario/{id}")
	public String deletarFuncionario(FuncionarioDto dto, Model model) {
		service.deletById(dto);
		return homeFuncionario(model);
	}
	
	@GetMapping("/formularioAtualizarFuncionario/{id}")
	public String formularioatualizarFuncionario(FuncionarioDto dto, Model model) {
		Funcionario funcionario = service.findById(dto);
		model.addAttribute("funcionario", funcionario);
		return "funcionario/formularioAtualizarFuncionario";
	}
	
	@PostMapping("/atualizarFuncionario")
	public String atualizarFuncionario(FuncionarioDto dto, Model model) {
		service.upadate(dto);
		return homeFuncionario(model);
	}
		
}
