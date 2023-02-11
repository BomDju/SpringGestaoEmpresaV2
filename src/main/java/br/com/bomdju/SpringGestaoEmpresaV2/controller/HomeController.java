package br.com.bomdju.SpringGestaoEmpresaV2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/")
public class HomeController {

	@GetMapping("/")
	public String testHome() {
		return "home";

	}
	

	
	


	
}
