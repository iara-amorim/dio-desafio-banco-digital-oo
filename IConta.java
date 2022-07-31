
public interface IConta {

	void sacar(double valor);

	void depositar(double valor);

	void transferir(double valor, IConta contaDestino);

	void addTransacao(String tipo, double valor, String descritivo);

	void imprimirExtrato();
}
