package br.com.alura;

public class TesteBuscaAlunosnoCurso {

	public static void main(String[] args) {

		Curso javaColecoes = new Curso("Dominando as coleções", "Paulo");
		
		javaColecoes.adiciona(new Aula("Trabalando com ArrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));
		
		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Guilherme Silveira", 5671);
		Aluno a3 = new Aluno("Mauricio Aniche", 17654);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);

		System.out.println("Quem é o aluno com matricula 5671?");
		Aluno aluno = javaColecoes.buscaMatriculado(5671);
		System.out.println(aluno);
		
	}

}
