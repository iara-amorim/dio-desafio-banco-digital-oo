import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Banco banco = new Banco(1, "Banco Digital OO");
		System.out.println("Bem vindo ao banco " + banco);

		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o nome do Cliente:\n>");
		String nome = entrada.next();
		System.out.println("Informe o sobrenome do Cliente:\n>");
		String sobrenome = entrada.next();
		System.out.println("Informe a renda mensal do Cliente:\n>");
		double renda = entrada.nextDouble();

		Cliente cliente = new Cliente(nome, sobrenome, renda);
		System.out.println("Cliente cadastrado com sucesso. O código do Cliente é: " + cliente.codigo);
		Conta conta;
		if (cliente.limiteDisponivel() > 0 && renda > 100) {
			conta = new ContaCorrente(banco, cliente, renda);
			System.out
					.println("Conta Corrente aberta com sucesso: " + conta + " com limite de "
							+ String.format("%.2f", cliente.limiteDisponivel()));
		} else {
			conta = new ContaPoupanca(banco, cliente);
			System.out.println("Conta Poupança aberta com sucesso: " + conta);
		}
		System.out.println("Valor de depósito inicial:\n> ");
		double depositoInicial = entrada.nextDouble();
		conta.depositar(depositoInicial);
		conta.imprimirExtrato();
		entrada.close();
	}

}