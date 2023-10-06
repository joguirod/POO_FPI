package Exercicio06;

import Exercicio04.classes.Conta.Conta;

public class TestaContaEncapsulada {
    public static void main(String[] args) {
        Conta conta1 = new Conta("1111", "Guilherme", 100);
        System.out.println(conta1.getSaldo());
    }
}
