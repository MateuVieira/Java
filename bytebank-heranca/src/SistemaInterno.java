
public class SistemaInterno {

	private int senha = 2222;
	
	public void autentica(Autenticavel fa) {
		
		boolean autentica = fa.autentica(this.senha);
		if (autentica) {
			System.out.println("Pode entrar no Sistema");
		}
		System.out.println("N�o pode entrar no Sistema");
	}
}
