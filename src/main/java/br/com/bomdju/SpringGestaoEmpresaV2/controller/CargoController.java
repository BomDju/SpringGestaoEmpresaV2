package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String formularioNovoCargo() {
		
		return "cargo/formularioCargo";

	}
	
	@GetMapping("/homeCargo")
	public String cargoHome(CargoDto dto, Model model) {
		List<Cargo> cargo = service.findAllAtivo();
		model.addAttribute("Cargo", cargo);
		return "cargo/homeCargo";
	}
	
	

}
