package br.com.alura;

public class TestaCusocomAluno {

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
		
		System.out.println("Todos os aluno matricularos: ");
		javaColecoes.getAlunos().forEach(a -> System.out.println(a));
		
		
		System.out.println(javaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		System.out.println("E esse Turini, está matriculado?");
		System.out.println(javaColecoes.estaMatriculado(turini));
		
		System.out.println("O a1 é equals ao Turini?");
		System.out.println(a1.equals(turini));
	}

}
