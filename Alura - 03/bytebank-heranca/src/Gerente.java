
public class Gerente extends Funcionario implements Autenticavel {

	
	
	public double getBonificacao() {
		return super.getSalario();
	}
	
	private AutenticadorUtil util;
	
	public Gerente() {
		this.util = new AutenticadorUtil();
	}
	
	@Override
	public boolean autentica(int senha) {
		return this.util.autentica(senha);
	}

	@Override
	public void setSenha(int senha) {
		this.util.setSenha(senha);
		
	}
}
