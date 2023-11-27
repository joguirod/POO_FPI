package AtividadeAvaliativa01.questao06;

import AtividadeAvaliativa01.Conta;

public class TestaConta {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1111-1", "guilherme", 100);
        Conta conta2 = new Conta("2222-2", "caloteiro", -70);
        conta1.depositar(-20);
        conta1.sacar(-80);
    }
}

/*

   !!! Executando a linha 8 !!!:

    Exception in thread "main" java.lang.Error: Saldo inválido! (menor do que 0)
    at AtividadeAvaliativa01.Conta.<init>(Conta.java:21)
    at AtividadeAvaliativa01.questao06.TestaConta.main(TestaConta.java:8)

    Process finished with exit code 1

   !!! Executando a linha 9 ou 10!!!:

    Exception in thread "main" java.lang.Error: Valor fornecido menor do que 0!
	at AtividadeAvaliativa01.Conta.depositar(Conta.java:42)
	at AtividadeAvaliativa01.questao06.TestaConta.main(TestaConta.java:9)

	Process finished with exit code 1

 */