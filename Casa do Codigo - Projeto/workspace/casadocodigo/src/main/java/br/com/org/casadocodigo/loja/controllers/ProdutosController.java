package br.com.org.casadocodigo.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.org.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/form")
	public String form() {
		System.out.println("/produtos/form");
		return "produtos/form";
	}
	
	@RequestMapping("/produtos/ok")
	public String grava(Produto produto) {
		System.out.println(produto);
		
		return "produtos/ok";
	}
}
