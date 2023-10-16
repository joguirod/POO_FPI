package Exercicio07.questoes0203;

public class ScientificCalculator extends Calculator {

    public ScientificCalculator(double operator1, double operator2) {
        super(operator1, operator2);
    }

    public double exponentiation() {
        return Math.pow(getOperator1(), getOperator2());
    }
}
