import java.util.ArrayList;

public class Banco {

	public int codigo;
	public String nome;
	private ArrayList<Conta> contas;

	Banco(int codigo, String nome) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public String toString() {
		return String.join(" - ", String.format("%03d", this.codigo), this.nome);
	}

}
