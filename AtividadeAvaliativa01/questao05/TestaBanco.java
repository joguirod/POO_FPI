package AtividadeAvaliativa01.questao05;

import AtividadeAvaliativa01.Banco;
import AtividadeAvaliativa01.Conta;

public class TestaBanco {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.inserir(new Conta("1111-1", "Guilherme", 1000));
        banco.inserir(new Conta("2222-2", "Patricio", 600));

        banco.transferir("1111-1", "2222-2", 700);
    }
}

/*

    Instancie uma classe banco e crie duas contas. Adicione-as à instancia do banco.
    Chame o método transferir novamente passando um valor que lance a exceção na
    classe conta. Você considera que o lançamento da exceção foi “propagado” para o
    método conta.transferir(), banco.transferir() e o método transferir do script app?
    Como você avalia a confiabilidade dessa implementação.


    Saída:
    Exception in thread "main" java.lang.Error: Saldo insuficiente
	at AtividadeAvaliativa01.questao05.Conta.sacar(Conta.java:21)
	at AtividadeAvaliativa01.questao05.Conta.transferir(Conta.java:37)
	at AtividadeAvaliativa01.Banco.transferir(Banco.java:84)
	at AtividadeAvaliativa01.questao05.TestaBanco.main(TestaBanco.java:10)

    Resposta: Esses métodos no final das contas executam conta.transferir(),
    que ao lançar a exceção (não tratada), finaliza o programa, acredito que
    o lançamento é "propagado" no sentido de que a exceção ocorre na classe
    conta e o erro se "manifesta" em todos esses métodos. Acredito que essa
    implementação é confiavél, já que o tratamento do erro continua sendo
    possível no script do app, por exemplo. Ou seja, a implementação não impede
    o tratamento da exceção, o que traz confiabilidade.
 */