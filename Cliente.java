
public class Cliente {
	private static int SEQUENCIAL = 1;
	protected int codigo;
	private String nome;
	private String sobrenome;
	private double renda = 0;

	Cliente(String nome, String sobrenome, double renda) {
		this.codigo = SEQUENCIAL++;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.renda = renda;
	}

	public String toString() {
		return this.codigo + " " + this.nomeCompleto();
	}

	public String nomeCompleto() {
		return String.join(" ", this.nome, this.sobrenome);
	}

	protected double limiteDisponivel() {
		return (this.renda / 100) * 30;
	}

}
