package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoes {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for (Conta conta : todasAsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentacoes: ");
			for (Movimentacao movimentacao : conta.getMovimentacoes()) {	
				System.out.println("    " + movimentacao.getTipo() +
						" -->  " + movimentacao.getDescricao());
			}
			System.out.println("\n ***************** \n");
			
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
