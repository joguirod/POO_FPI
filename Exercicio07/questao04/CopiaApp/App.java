package Exercicio07.questao04.CopiaApp;

import Exercicio04.classes.Conta.Conta;
import Exercicio07.questao04.ContaImposto;
import Exercicio07.questao04.Poupanca;
import Exercicio07.questao04.CopiaApp.Banco.Banco;
import java.io.*;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Banco banco = new Banco();
        App app = new App();
        app.lerContas(banco);

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
                case 8:
                    System.out.println("\nRender Juros\n");
                    app.renderJuros(banco);
                    break;
                default:
                    if (opcao != 0) {
                        System.out.println("Opção Inválida!");
                    }
                    break;
            }

            app.meuContinue(app);

        } while (opcao != 0);
        app.salvarContas(banco);

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
                + "\n8 - Render Juros"
                + "\n0 - Sair";
    }

    public void cadastrar(Banco banco){
        System.out.println("Qual o tipo da conta? (C/CP/CI)");
        String tipoConta = scanner.next();
        System.out.println("Número da conta: ");
        String numero = scanner.next();
        System.out.println("Titular da conta: ");
        String titular = scanner.next();
        if(tipoConta.equals("CP")){
            System.out.println("Taxa de juros da conta: ");
            double taxaJuros = scanner.nextDouble();
            Poupanca poupanca = new Poupanca(numero, titular, 0, taxaJuros);
            banco.inserir(poupanca);
        } else if (tipoConta.equals("CI")) {
            System.out.println("Taxa de desconto da conta: ");
            double taxaDesconto = scanner.nextDouble();
            ContaImposto contaImposto = new ContaImposto(numero, titular, 0, taxaDesconto);
            banco.inserir(contaImposto);
        } else {
            Conta conta = new Conta(numero, titular, 0);
            banco.inserir(conta);
        }
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

    public void renderJuros(Banco banco){
        System.out.println("Qual o número da conta?");
        String numero = scanner.next();
        banco.renderJuros(numero);
    }

    public void salvarContas(Banco banco) throws IOException {
        File file = new File("C:\\Users\\José Guilherme\\Documents\\POO_FPI\\Exercicio07\\questao04\\CopiaApp\\contas.txt");
        FileWriter fileWriter = new FileWriter(file);

        for (Conta conta : banco.getContas()) {
            if (conta instanceof Poupanca) {
                fileWriter.write(conta.getNumero() + "; " + conta.getSaldo() + "; CP" + "; "
                        + ((Poupanca) conta).getTaxaJuros() + "\n");
            } else if (conta instanceof ContaImposto) {
                fileWriter.write(conta.getNumero() + "; " + conta.getSaldo() + "; CI" + "; "
                        + ((ContaImposto) conta).getTaxaDesconto() + "\n");
            } else {
                fileWriter.write(conta.getNumero() + "; " + conta.getSaldo() + "; C\n");
            }
        }

        fileWriter.close();
    }

    public void lerContas(Banco banco) throws IOException {
        File file = new File("C:\\Users\\José Guilherme\\Documents\\POO_FPI\\Exercicio07\\questao04\\CopiaApp\\contas.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linha = bufferedReader.readLine();

        while (linha != null) {
            String[] partes = linha.split("; ");
            String numero = partes[0];
            double saldo = Double.parseDouble(partes[1]);
            String tipo = partes[2];
            if (tipo.equals("CP")) {
                double taxaJuros = Double.parseDouble(partes[3]);
                Poupanca poupanca = new Poupanca(numero, saldo, taxaJuros);
                banco.inserir(poupanca);
            } else if (tipo.equals("CI")) {
                double taxaDesconto = Double.parseDouble(partes[3]);
                ContaImposto contaImposto = new ContaImposto(numero, saldo, taxaDesconto);
                banco.inserir(contaImposto);
            } else {
                Conta conta = new Conta(numero, saldo);
                banco.inserir(conta);
            }
            linha = bufferedReader.readLine();
        }

        fileReader.close();
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