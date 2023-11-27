package AtividadeAvaliativa01.questao04;

import AtividadeAvaliativa01.Conta;

public class TestaConta {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1111-1", "guilherme", 100);
        Conta conta2 = new Conta("2222-2", "caloteiro", 15);
        conta2.transferir(conta1, 20);
    }
}

/*

    Explicação 01: (Fiquei em dúvida sobre o que deveria ser feito lendo a questão)
    Alteração no método transferir de conta: Remoção do if-else e o método agora é void, lançamento de erro realizado
    no this.sacar(valor) dentro de transferir, caso o saldo seja insuficiente, a exceção será lançada:
    Exception in thread "main" java.lang.Error: Saldo insuficiente
	at AtividadeAvaliativa01.questao04.Conta.sacar(Conta.java:21)
	at AtividadeAvaliativa01.questao04.Conta.transferir(Conta.java:37)
	at AtividadeAvaliativa01.questao04.TestaConta.main(TestaConta.java:7)


    Explicação 02:
    !!! Executando com o método antigo, nenhuma exceção era lançada, o programa executaria
    e o valor não iria ser trasnferido !!!

    Método antes das alterações:

    public boolean transferir(Conta ContaDestino, double valor){
        if (_saldo < 0 || _saldo - valor < 0){
            return false;
        }

        this.sacar(valor);
        ContaDestino.depositar(valor);
        return true;
    }

 */