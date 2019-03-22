package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutosController {

	@Autowired
	private ProdutoDAO dao;

	@RequestMapping("/produtos/form")
	public String form() {
		System.out.println("/produtos/form");
		return "produtos/form";
	}

	@RequestMapping("/produtos")
	public String gravar(Produto produto) {
		System.out.println(produto);
		if (produto.getTitulo() != null) {
			dao.gravar(produto);
			return "/produtos/ok";
		}
		return "produtos/form";
	}
}