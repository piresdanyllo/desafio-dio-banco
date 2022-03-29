
public class Main {

	public static void main(String[] args) {

		Cliente danyllo = new Cliente();
		danyllo.setNome("Danyllo");
		Conta cc = new ContaCorrente(danyllo);
		Conta cp = new ContaPoupanca(danyllo);
		
		cc.depositar(100);
		cc.transferir(cp, 100);
		cc.imprimirExtrato();
		cp.imprimirExtrato();

	}

}
