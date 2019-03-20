package bytebank;

public class Conta {

	private double saldo = 0;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	/// Construtor
	
	public Conta() {
		Conta.total ++;
	}
	
	
	/// Saldo
	public double getSaldo() {
		return this.saldo;
	}
	
	/// Agencia
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	/// Numero
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	/// Titular
	public Cliente getTitular() {
		return this.titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	/// Total
	
	public static int getTotal() {
		return Conta.total;
	}
	
	/// Metodos
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			return true;
		} 
		return false;
	}
	
	public boolean transfere(double valor, Conta destino) {
		if (this.saca(valor)) {
			destino.deposita(valor);
			return true;
		}
		return false;
	}
}
