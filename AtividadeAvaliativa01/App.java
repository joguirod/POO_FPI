package AtividadeAvaliativa01;

import java.io.*;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static Banco banco = new Banco();

    public static void main(String[] args) throws IOException {
        lerContas();

        int opcao;

        System.out.println("Bem vindo!");
        do {
            System.out.println("\nOpções disponíveis:");
            System.out.println("\n" + opcoes());
            System.out.print("Digite uma opção: ");
            opcao = scanner.nextInt();
            meuCtrlL();

            // 14ª questão - Adição do tratamento de exceções como no slide Aplicação Robusta:
            try{
                switch(opcao) {
                    case 1:
                        System.out.println("\nCadastrar Conta\n");
                        cadastrar();
                        System.out.println("Conta cadastrada com sucesso!");
                        break;
                    case 2:
                        System.out.println("\nConsultar conta\n");
                        consultar();
                        break;
                    case 3:
                        System.out.println("\nSacar\n");
                        sacar();
                        break;
                    case 4:
                        System.out.println("\nDepositar\n");
                        depositar();
                        break;
                    case 5:
                        System.out.println("\nExcluir conta\n");
                        excluir();
                        break;
                    case 6:
                        System.out.println("\nTransferir\n");
                        transferir();
                        break;
                    case 7:
                        System.out.println("\nTotalizações\n");
                        System.out.println(totalizacoes());
                        break;
                    case 8:
                        System.out.println("\nRender Juros\n");
                        renderJuros();
                        break;
                    default:
                        if (opcao != 0) {
                            System.out.println("Opção Inválida!");
                        }
                        break;
                }

                meuContinue();

            } catch (Exception e){
                if(e instanceof AplicacaoError){
                    System.out.println(e.getMessage());
                }
                else if(e instanceof InputError){
                    System.out.println(e.getMessage());
                }
                else if(e instanceof RuntimeException){
                    System.out.println("Erro no sistema. Contate o administrador.");
                }
            } finally {
                System.out.println("Operação finalizada. Digite 0 para sair.");
                meuContinue();
            }

        } while (opcao != 0);
        salvarContas();

        System.out.println("Tchau bb!");
    }

    public static String opcoes(){
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

    public static void cadastrar(){
        String tipoConta = obterEntradaString("Qual o tipo da conta? (C/CP/CI)");
        String numero = obterNumeroConta("Número da conta: ");
        String titular = obterEntradaString("Titular da conta: ");
        if(tipoConta.equals("CP")){
            double taxaJuros = obterNumero("Taxa de juros da conta (em %): ");
            Poupanca poupanca = new Poupanca(numero, titular, 0, taxaJuros);
            banco.inserir(poupanca);
        } else if (tipoConta.equals("CI")) {
            double taxaDesconto = obterNumero("Taxa de desconto da conta: ");
            ContaImposto contaImposto = new ContaImposto(numero, titular, 0, taxaDesconto);
            banco.inserir(contaImposto);
        } else {
            Conta conta = new Conta(numero, titular, 0);
            banco.inserir(conta);
        }
    }

    public static void consultar(){

        String numero = obterNumeroConta("Digite o número da conta a ser consultada: ");
        double saldo = banco.consultar(numero).consultarSaldo();
        System.out.printf("Saldo da conta %s: %.2f%n", numero, saldo);
    }

    public static void sacar(){
        String numero = obterNumeroConta("Digite o número da conta para saque: ");
        double valor = obterNumero("Qual o valor a ser sacado? ");

        banco.sacar(numero, valor);

    }

    public static void depositar(){
        String numero = obterNumeroConta("Digite o número da conta para depósito: ");
        double valor = obterNumero("Qual o valor a ser depositado? ");

        banco.consultar(numero).depositar(valor);
    }

    public static void excluir(){
        String numero = obterNumeroConta("Qual o número da conta a ser excluída? ");

        banco.excluir(numero);
    }

    public static void transferir(){
        String numeroOrigem = obterNumeroConta("Digite o número da conta de origem: ");
        String numeroDestino = obterNumeroConta("Digite o número da conta de destino: ");
        double valor = obterNumero("Qual o valor a ser transferido?\n> ");

        Conta contaOrigem = banco.consultar(numeroOrigem);
        Conta contaDestino = banco.consultar(numeroDestino);

        contaOrigem.transferir(contaDestino, valor);
    }

    public static String totalizacoes(){
        return "Quantidade de contas: " + banco.qtdContas()
                + "\nTotal depositado: " + banco.totalDepositado()
                + "\nMédia de valor depositado: " + banco.mediaDepositado();
    }

    public static void renderJuros(){
        String numero = obterNumeroConta("Qual o número da conta?");
        banco.renderJuros(numero);
    }

    public static void salvarContas() throws IOException {
        File file = new File("C:\\Users\\José Guilherme\\Documents\\POO_FPI\\AtividadeAvaliativa01\\contas.txt");
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

    public static void lerContas() throws IOException {
        File file = new File("C:\\Users\\José Guilherme\\Documents\\POO_FPI\\AtividadeAvaliativa01\\contas.txt");
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

    public static void meuCtrlL(){
        System.out.println("\n".repeat(20));
    }


    // 15 questão: adicionando exceção na entrada de dados.
    public static String obterEntradaString (String label) throws StringInvalidaError, InputVazioError{
        System.out.println(label);
        String entrada = scanner.nextLine().trim();

        if(entrada.equals(" ")){
            throw new InputVazioError("Input vazio não é permitido.");
        } else if(!contemApenasLetras(entrada)){
            throw new StringInvalidaError("O input deve conter apenas letras.");
        }

        return entrada;
    }

    // 15 questão: adicionando exceção na entrada de dados.
    public static String obterNumeroConta(String label){
        System.out.println(label);
        String entrada = scanner.nextLine().trim();

        if(!contemApenasNumeros(entrada)){
            throw new NumeroContaInvalidoError("O número da conta não pode ter letras.");
        }

        return entrada;
    }

    // 15 questão: adicionando exceção na entrada de dados.
    public static Double obterNumero(String label){
        System.out.println(label);
        String entrada = scanner.nextLine().trim();
        for(int i = 0; i < entrada.length(); i++){
            char caractere = entrada.charAt(i);
            if(!Character.isDigit(caractere)){
                if(caractere != '.'){
                    throw new NumeroInvalidoError("O número informado é inválido.");
                }
                else if (!Character.isDigit(entrada.charAt(i+1))){
                    throw new NumeroInvalidoError("O número informado é inválido.");
                }
            }
        }
        return Double.parseDouble(entrada);
    }

    public static boolean contemApenasLetras(String entrada){
        boolean apenasLetras = true;
        for(int i = 0; i < entrada.length(); i++){
            if(!Character.isLetter(entrada.charAt(i))){
                apenasLetras = false;
            }
        }
        return apenasLetras;
    }

    public static boolean contemApenasNumeros(String entrada){
        boolean apenasNumeros = true;
        for(int i = 0; i < entrada.length(); i++){
            char caractere = entrada.charAt(i);
            if(Character.isLetter(caractere)){
                apenasNumeros = false;
            }
        }
        return apenasNumeros;
    }

    public static void meuContinue(){
        System.out.print("Pressione Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }
}