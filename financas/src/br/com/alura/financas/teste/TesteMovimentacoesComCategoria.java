package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args) {
		
		Categoria categoria1 = new Categoria();
		categoria1.setNome("viagem");
		
		Categoria categoria2 = new Categoria();
		categoria2.setNome("negocios");
		
		Conta conta = new Conta();
		conta.setTitular("Leonard");
		conta.setBanco("Caixa Economica");
		conta.setAgencia("123");
		conta.setNumero("456");
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem a São Paulo");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("200.0"));
		movimentacao1.setConta(conta);
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem a Rio");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("200.0"));
		movimentacao2.setConta(conta);
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(categoria1 );
		em.persist(categoria2);
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
		
	}
	
	
}
