import java.util.Scanner;

public class ContaBancaria {

    private String nomeTitular;
    private double saldo;

    public ContaBancaria(String nomeTitular, double saldoInicial) {
        this.nomeTitular = nomeTitular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        mostrarSaldo();
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
        mostrarSaldo();
    }

    public void mostrarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do titular da conta: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(nome, saldoInicial);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Ver saldo");
            System.out.println("4 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = scanner.nextDouble();
                    conta.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = scanner.nextDouble();
                    conta.sacar(valorSaque);
                    break;
                case 3:
                    conta.mostrarSaldo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
