
public class TesteFuncionario {

	public static void main(String[] args) {

		Gerente nico = new Gerente();
		
		nico.setNome("Nico");
		nico.setCPF("4214124124");
		nico.setSalario(5000.00);
		
		System.out.println("Bonus = "  + nico.getBonificacao());
	}

}
