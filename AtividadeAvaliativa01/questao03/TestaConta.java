package AtividadeAvaliativa01.questao03;

import AtividadeAvaliativa01.Conta;

public class TestaConta {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1111-1", "guilherme", 100);
        Conta conta2 = new Conta("2222-2", "caloteiro", 15);
        conta1.sacar(100);
        conta2.sacar(50);
    }
}

/*
    Saída do programa: Exception in thread "main" java.lang.Error: Saldo insuficiente
	at AtividadeAvaliativa01.questao03.Conta.sacar(Conta.java:21)
	at AtividadeAvaliativa01.questao03.TestaConta.main(TestaConta.java:8)

    *java.lang.Error: Saldo insuficiente*

 */