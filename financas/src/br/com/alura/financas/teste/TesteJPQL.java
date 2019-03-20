package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(5);
		
		String query = "select m from Movimentacao m where m.conta = :pConta";
		Query q = em.createQuery(query);
		q.setParameter("pConta", conta);
		
		List<Movimentacao> resultados = q.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Drecrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();

	}

}
