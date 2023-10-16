package Exercicio07.questoes0203;

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator(2, 4);
        System.out.println("Soma (Calculator): " + calc.sum());

        ScientificCalculator scalc = new ScientificCalculator(2, 4);
        System.out.println("Exponenciação (ScientificCalculator): " + scalc.exponentiation());
    }
}

// Não foi necessária nenhuma modificação na classe Calculadora.
