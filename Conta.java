import java.util.ArrayList;

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected String nroConta;
	protected double saldo = 0;
	protected Banco banco;
	protected Cliente cliente;
	protected ArrayList<Transacao> transacoes = new ArrayList<>();

	public Conta(Banco banco, Cliente cliente) {
		this.banco = banco;
		this.agencia = Conta.AGENCIA_PADRAO;
		this.nroConta = String.format("%08d", SEQUENCIAL++);
		this.cliente = cliente;
		banco.addConta(this);
	}

	public void sacar(double valor) {
		if (this.saldo >= valor) {
			saldo -= valor;
			this.addTransacao("S", valor, "Saque");
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
		this.addTransacao("C", valor, "Depósito");
	}

	@Override
	public void transferir(double valor, IConta contaDestino) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
			this.addTransacao("D", valor, "Tranferência");
			contaDestino.depositar(valor);
			contaDestino.addTransacao("C", valor, "Tranferência");
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	public void addTransacao(String tipo, double valor, String descritivo) {
		this.transacoes.add(new Transacao(tipo, valor, descritivo));
	}

	public String toString() {
		return String.format("%04d", this.agencia) + '-' + this.nroConta;
	}

	public void imprimirExtrato() {
		System.out.println("---------------------------------------------------------------------------");
		this.imprimirInfosComuns();
		if (this.transacoes.size() > 0) {
			for (Transacao transacao : this.transacoes) {
				System.out.println(transacao);
			}
		} else {
			System.out.println("Nenhuma transação encontrada");
		}
		System.out.println("---------------------------------------------------------------------------");
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente));
		System.out.println(String.format("Conta: %d-%s", this.agencia, this.nroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
