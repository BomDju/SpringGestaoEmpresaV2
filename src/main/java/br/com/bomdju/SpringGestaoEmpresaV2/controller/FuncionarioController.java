package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.FuncionarioDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Funcionario;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Setor;
import br.com.bomdju.SpringGestaoEmpresaV2.service.FuncinarioService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("funcionario")
public class FuncionarioController {

	@Autowired
	private FuncinarioService service;

	@GetMapping("/formularioFuncionario")
	public String formulario(Model model, FuncionarioDto dto) {
		List<Cargo> cargos = service.findAllCargo();
		model.addAttribute("cargos", cargos);

		List<Setor> setores = service.findAllSetor();
		model.addAttribute("setores", setores);
		return "funcionario/formularioAdicionaFuncionario";
	}

	@GetMapping("/homeFuncionario")
	public String homeFuncionario(Model model) {
		List<Funcionario> funcionarios = service.findAllFuncionariosAtivo();
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/homeFuncionario";
	}

	@GetMapping("/visualizarFuncionario")
	public String vizualizarFuncionario() {
		return "funcionario/visualizarFuncionario";
	}

	@PostMapping("/cadastrarFuncionario")
	public String cadastrarNovoFuncionario(@Valid FuncionarioDto dto,  BindingResult result, Model model) {
		if(result.hasErrors()) {
		return formulario(model, dto);
		}
		service.save(dto);
		return homeFuncionario(model);

	}

	@PostMapping("/buscaFuncionario")
	public String buscaFuncionario(FuncionarioDto dto, Model model) {
		Funcionario funcionarios = service.findById(dto);
		model.addAttribute("funcionarios", funcionarios);
		return "funcionario/homeFuncionario";
	}

	@GetMapping("/deletarFuncionario/{id}")
	public String deletarFuncionario(FuncionarioDto dto, Model model) {
		service.setaAtivoFalse(dto);
		return homeFuncionario(model);
	}

	@GetMapping("/formularioAtualizarFuncionario/{id}")
	public String formularioatualizarFuncionario(FuncionarioDto dto, Model model) {
		Funcionario funcionario = service.findById(dto);
		model.addAttribute("funcionario", funcionario);

		List<Cargo> cargos = service.findAllCargo();
		model.addAttribute("cargos", cargos);

		List<Setor> setores = service.findAllSetor();
		model.addAttribute("setores", setores);
		return "funcionario/formularioAtualizarFuncionario";
	}

	@PostMapping("/atualizarFuncionario")
	public String atualizarFuncionario(FuncionarioDto dto, Model model) {
		service.update(dto);
		return homeFuncionario(model);
	}

	@GetMapping("/vizualizarFuncionario/{id}")
	public String vizualizarFuncionario(FuncionarioDto dto, Model model) {
		Funcionario funcionario = service.findById(dto);
		model.addAttribute("funcionario", funcionario);
		return "funcionario/vizualizarFuncionario";
	}

}
