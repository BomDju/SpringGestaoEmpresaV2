package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.CargoDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.service.CargoService;

@Controller
@RequestMapping("cargo")
public class CargoController {

	@Autowired
	CargoService service = new CargoService();
	
	@GetMapping("/formularioCargo")
	public String formularioCargo() {
		return "/cargo/formularioAdicionaCargo";
	}

	@PostMapping("/formularioAdicionaCargo")
	public String formularioNovoCargo(CargoDto dto, Model model) {
		service.save(dto);
		return homeCargo(model);

	}

	@GetMapping("/homeCargo")
	public String homeCargo(Model model) {
		List<Cargo> cargos = service.findAllAtivo();
		model.addAttribute("cargos", cargos);
		return "/cargo/homeCargo";
	}
	
	@GetMapping("/deletaCargo/{id}")
	public String deletaCargo(CargoDto dto, Model model) {
		service.deletById(dto);
		return homeCargo(model); 
	}
	
	@PostMapping("/buscarCargo")
	public String buscarCargo(CargoDto dto, Model model){
		List<Cargo> cargos = service.buscaPorNome(dto);
		model.addAttribute("cargos", cargos);
		return "/cargo/homeCargo";
	}
	
	@GetMapping("/formularioAtualizaCargo/{id}")
	public String atulizaCargo(CargoDto dto, Model model) {
		Cargo cargo =  service.findById(dto);
		model.addAttribute("cargo", cargo);
		return "/cargo/formularioAtualizaCargo";
					   
	}
	
	@PostMapping("/atualizarCargo")
	public String atualizarCargo(CargoDto dto, Model model) {
		service.upadateCargo(dto);
		return homeCargo(model);
	}
}
