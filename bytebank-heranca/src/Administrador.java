
public class Administrador extends Funcionario implements Autenticavel{
	
	
	public double getBonificacao() {
		return super.getSalario();
	}

	private AutenticadorUtil util;
	
	public Administrador() {
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
