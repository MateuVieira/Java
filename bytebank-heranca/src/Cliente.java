
public class Cliente implements Autenticavel {

	private AutenticadorUtil util;
	
	public Cliente() {
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
