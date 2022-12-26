package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.bomdju.SpringGestaoEmpresaV2.service.CargoService;

public class CargoController {

	@Autowired
	private CargoService service;
	
	@GetMapping("/id")
	public String findById(Integer id) {
		service.findById(id);
		return "/id";
		
	}
}
