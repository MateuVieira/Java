package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mysql.cj.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDao {

	private EntityManager em;

	public MovimentacaoDao(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasPorDIaETipo(TipoMovimentacao saida, Conta conta) {

		String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta = :pConta"
				+ "and m.tipo = :pTipo group by m.data";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return query.getResultList();
	}
}