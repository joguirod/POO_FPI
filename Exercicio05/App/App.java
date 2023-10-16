package Exercicio05.App;
import Exercicio05.App.Banco.Banco;
import java.util.Scanner;
import Exercicio04.classes.Conta.Conta;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        App app = new App();
        Banco banco = new Banco();
        
        int opcao;
        
        System.out.println("Bem vindo!");
        do {
            System.out.println("\nOpções disponíveis:");
            System.out.println("\n" + app.opcoes());
            System.out.print("Digite uma opção: ");
            opcao = app.scanner.nextInt();
            app.meuCtrlL();

            switch(opcao) {
                case 1:
                    System.out.println("\nCadastrar Conta\n");
                    app.cadastrar(banco);
                    System.out.println("Conta cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.println("\nConsultar conta\n");
                    app.consultar(banco);
                    break;
                case 3:
                    System.out.println("\nSacar\n");
                    app.sacar(banco);
                    break;
                case 4:
                    System.out.println("\nDepositar\n");
                    app.depositar(banco);
                    break;
                case 5:
                    System.out.println("\nExcluir conta\n");
                    app.excluir(banco);
                    break;
                case 6:
                    System.out.println("\nTransferir\n");
                    app.transferir(banco);
                    break;
                case 7:
                    System.out.println("\nTotalizações\n");
                    System.out.println(app.totalizacoes(banco));
                    break;
                default:
                    if (opcao != 0) {
                        System.out.println("Opção Inválida!");
                    }
                    break;
            }

            app.meuContinue(app);
            
        } while (opcao != 0);

        System.out.println("Tchau bb!");
    }

    public String opcoes(){
        return "1 - Cadastrar"
        + "\n2 - Consultar"
        + "\n3 - Sacar"
        + "\n4 - Depositar"
        + "\n5 - Excluir"
        + "\n6 - Transferir"
        + "\n7 - Totalizações"
        + "\n0 - Sair";
    }

    public void cadastrar(Banco banco){
        System.out.println("Número da conta: ");
        String numero = scanner.next();
        System.out.println("Titular da conta: ");
        String titular = scanner.next();
        Conta conta = new Conta(numero, titular, 0);

        banco.inserir(conta);
    }

    public void consultar(Banco banco){
        System.out.println("Digite o número da conta a ser consultada: ");
        String numero = scanner.next();
        double saldo = banco.consultar(numero).consultarSaldo();
        System.out.printf("Saldo da conta %s: %.2f%n", numero, saldo);
    }

    public void sacar(Banco banco){
        System.out.println("Digite o número da conta para saque: ");
        String numero = scanner.next();
        System.out.println("Qual o valor a ser sacado? ");
        double valor = scanner.nextDouble();

        banco.sacar(numero, valor);
        
    }

    public void depositar(Banco banco){
        System.out.println("Digite o número da conta para depósito: ");
        String numero = scanner.next();
        System.out.println("Qual o valor a ser depositado? ");
        double valor = scanner.nextDouble();

        banco.consultar(numero).depositar(valor);
    }

    public void excluir(Banco banco){
        System.out.println("Qual o número da conta a ser excluída?");
        String numero = scanner.next();

        banco.excluir(numero);
    }

    public void transferir(Banco banco){
        System.out.println("Digite o número da conta de origem: ");
        String numeroOrigem = scanner.next();
        System.out.println("Digite o número da conta de destino: ");
        String numeroDestino = scanner.next();
        System.out.println("Qual o valor a ser transferido?\n> ");
        double valor = scanner.nextDouble();

        Conta contaOrigem = banco.consultar(numeroOrigem);
        Conta contaDestino = banco.consultar(numeroDestino);

        contaOrigem.transferir(contaDestino, valor);
    }

    public String totalizacoes(Banco banco){
        return "Quantidade de contas: " + banco.qtdContas()
        + "\nTotal depositado: " + banco.totalDepositado()
        + "\nMédia de valor depositado: " + banco.mediaDepositado();
    }

    public void meuCtrlL(){
        System.out.println("\n".repeat(20));
    }

    public void meuContinue(App app){
        System.out.print("Pressione Enter para continuar...");
        app.scanner.nextLine();
        app.scanner.nextLine();
    }
}
