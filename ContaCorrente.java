
public class ContaCorrente extends Conta {

	protected double limite = 0;

	ContaCorrente(Banco banco, Cliente cliente, double renda) {
		super(banco, cliente);
		this.limite = (renda / 100) * 30;
	}

	@Override
	public void sacar(double valor) {
		if (this.saldo + this.limite >= valor) {
			saldo -= valor;
			this.addTransacao("S", valor, "Saque");
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("===== Extrato Conta Corrente =====");
		super.imprimirInfosComuns();
	}

}
