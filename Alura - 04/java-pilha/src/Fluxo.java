
public class Fluxo {

	public static void main(String[] args) {
        System.out.println("Ini do main");
        metodo1();
        System.out.println("Fim do main");
    }

    private static void metodo1() {
        System.out.println("Ini do metodo1");
        try {
        	  metodo2();
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        System.out.println("Fim do metodo1");
    }

    private static void metodo2() {
        System.out.println("Ini do metodo2");
        throw new ArithmeticException();
        //System.out.println("Fim do metodo2");
    }
}
