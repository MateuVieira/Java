package br.com.org.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/form")
	public String form() {
		System.out.println("/produtos/form");
		return "produtos/form";
	}
	
	@RequestMapping("/produtos")
	public String grava(String titulo, String descricao, int paginas) {
		System.out.println(titulo);
		System.out.println(descricao);
		System.out.println(paginas);
		
		return "ok";
	}
}
