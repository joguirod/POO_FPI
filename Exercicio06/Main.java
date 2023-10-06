package Exercicio06;

import Exercicio06.Entities.Calculadora;
import Exercicio06.Entities.Hora;

class Main{
    public static void main(String[] args) {
    /*
        /*Calculadora calc = new Calculadora(2, 4);
        System.out.println(calc.getOperando1());
        System.out.println(calc.soma());
        System.out.println(calc.multiplicacao());
     */
        Hora hora1 = new Hora(12, 30, 50);
        Hora hora2 = new Hora(12, 39, 50);
        System.out.println(hora1.toString());
        System.out.println(hora2.toString());
    }
}