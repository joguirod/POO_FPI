package classes.Conta;
import java.util.Scanner;

public class TestaConta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        Conta minhaConta = new Conta("71753", 0);
        Conta maeConta = new Conta("00001", 1000);

        do {
            System.out.println(showOpcoes());
            opcao = scanner.nextInt();
            menu(opcao, minhaConta, maeConta, scanner);
        }
        while (opcao != 0);
        
        scanner.close();
        System.out.println("Até mais!");
    }

    public static String showOpcoes(){
        String opcoes = "0 - Sair" 
        + "\n1 - Depositar minhaConta"
        + "\n2 - Sacar minhaConta"
        + "\n3 - Transferir minhaConta"
        + "\n4 - Depositar maeConta"
        + "\n5 - Sacar maeConta"
        + "\n6 - Transferir maeConta";
        return opcoes;
    }

    public static void menu(int opcao, Conta minhaConta, Conta maeConta, Scanner scanner){
        double valor;

        switch (opcao) {
            case 1:
                System.out.println("Qual o valor do depósito? ");  
                  
                valor = scanner.nextDouble();
                minhaConta.depositar(valor);
                System.out.println("\nDepósito realizado!\n");
                break;
            case 2:
                System.out.println("Qual o valor do saque? ");  
                  
                valor = scanner.nextDouble();
                if (!minhaConta.sacar(valor)){
                    System.out.println("\nSaldo insuficiente!\n");
                    break;
                }

                minhaConta.sacar(valor);
                System.out.println("\nSaque realizado!\n");
                break;
            case 3:
                System.out.println("Qual o valor da transferência?");
                valor = scanner.nextDouble();

                if (!minhaConta.transferir(maeConta, valor)){
                    System.out.println("\nSaldo insuficiente!\n");
                    break;
                }
                
                minhaConta.transferir(maeConta, valor);
                System.out.println("\nTransferência realizada com sucesso!\n");
                break;
            case 4:
                System.out.println("Qual o valor do depósito?");  
                  
                valor = scanner.nextDouble();
                maeConta.depositar(valor);
                System.out.println("\nDepósito realizado!\n");

                break;
            case 5:
                System.out.println("Qual o valor do saque?");  
                  
                valor = scanner.nextDouble();
                if (!maeConta.sacar(valor)){
                    System.out.println("\nSaldo insuficiente!\n");
                    break;
                }

                maeConta.sacar(valor);
                System.out.println("\nSaque realizado!\n");
                break;
            case 6:
                System.out.println("Qual o valor da transferência?");
                valor = scanner.nextDouble();

                if (!maeConta.transferir(minhaConta, valor)){
                    System.out.println("Saldo insuficiente!");
                    break;
                }
                
                maeConta.transferir(minhaConta, valor);
                System.out.println("\nTransferência realizada com sucesso!\n");
                break;
            default:
                System.out.println("\nOpção inválida!\n");
                break;
        }
    }
}
