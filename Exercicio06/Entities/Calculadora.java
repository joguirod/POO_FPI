package Exercicio06.Entities;

public class Calculadora {
    protected double _operando1;
    protected double _operando2;

    public Calculadora(double operando1, double operando2){
        this._operando1 = operando1;
        this._operando2 = operando2;
    }
    public double soma(){
        return _operando1+_operando2;
    }
    public double multiplicacao(){
        return _operando1*_operando2;
    }

    public double getOperando1() {
        return _operando1;
    }

    public double getOperando2() {
        return _operando2;
    }
}
