package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.dto.CargoDto;
import br.com.bomdju.SpringGestaoEmpresaV2.orm.Cargo;
import br.com.bomdju.SpringGestaoEmpresaV2.service.CargoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("cargo")
public class CargoController {

	@Autowired
	CargoService service = new CargoService();
	
	@GetMapping("/formularioCargo")
	public String formularioCargo(CargoDto dto) {
		return "/cargo/formularioAdicionaCargo";
	}

	@PostMapping("/formularioAdicionaCargo")
	public String formularioNovoCargo(@Valid CargoDto dto, Model model, BindingResult result) {
		if(result.hasErrors() || service.save(dto) == false) {
			result.rejectValue("nomeDoCargo","cargo.erro" ,"Este cargo já esta cadastrado");
			return formularioCargo(dto);
		}
		return homeCargo(model);
	}

	@GetMapping("/homeCargo")
	public String homeCargo(Model model) {
		List<Cargo> cargos = service.findAll();
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
	public String formularioAtualizaCargo(CargoDto dto, Model model) {
		CargoDto cargoDto =  service.findById(dto);
		model.addAttribute("cargo", cargoDto);
		return "/cargo/formularioAtualizaCargo";
					   
	}
	
	@PostMapping("/atualizarCargo")
	public String atualizarCargo(@Valid CargoDto dto, Model model, BindingResult result) {
		if(result.hasErrors() || service.upadateCargo(dto) == false) {
			result.rejectValue("nomeDoCargo","cargo.erro" ,"Este cargo já esta cadastrado");
			return formularioAtualizaCargo(dto, model);
		}
		return homeCargo(model);
	}
}
