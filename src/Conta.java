
public abstract class Conta implements IConta {

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	private static int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	public Conta(Cliente cliente) {
		   this.agencia = AGENCIA_PADRAO;
		   this.numero = SEQUENCIAL++;
		   this.cliente = cliente;
	}

	@Override
	public void sacar(double valor) {
		if (valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque realizado. Seu novo saldo é " + this.getSaldo());
		} else {
			System.out.println("Saldo insuficiente");
		}		
	}
	
	@Override
	public void depositar(double valor) {
		this.saldo += valor;
		System.out.println("Depósito realizado. Seu novo saldo é " + this.getSaldo());
	}
	
	@Override
	public void transferir(Conta contaDestino, double valor) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void imprimirInformacoes() {
		System.out.println("-----------------------------------------------------");
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		System.out.println("-----------------------------------------------------");
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	
}
