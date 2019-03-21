package br.com.org.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.org.casadocodigo.loja.models.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void gravar(Produto produto) {
		em.persist(produto);
	}
}
