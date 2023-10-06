package Exercicio06;

import Exercicio04.classes.Conta.Conta;
import Exercicio05.App.Banco.Banco;

public class TestaBancoEncapsulado {
    public static void main(String[] args) {
        Banco banco1 = new Banco();

        banco1.inserir(new Conta("1111", "Guilherme", 100));
        System.out.println(banco1.consultar("1111").consultarSaldo());
    }
}
