package Exercicio07.questoes0203;

public class Calculator {
    private double _operator1;
    private double _operator2;

    public Calculator(double operator1, double operator2){
        _operator1 = operator1;
        _operator2 = operator2;
    }

    public double sum(){
        return _operator1+_operator2;
    }

    public double getOperator1(){
        return _operator1;
    }
    public double getOperator2(){
        return _operator2;
    }
}
