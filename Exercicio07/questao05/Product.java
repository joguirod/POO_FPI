package Exercicio07.questao05;

import java.util.Date;

public class Product {
    private int _id;
    private String _name;
    private String _description;
    private int _stockQty;
    private double _unityPrice;

    public void replace(int replacementQty){
        _stockQty += replacementQty;
    }

    public void reduce(int reduceQty){
        _stockQty -= reduceQty;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public String getDescription() {
        return _description;
    }

    public int getStockQty() {
        return _stockQty;
    }

    public double getUnityPrice() {
        return _unityPrice;
    }
}

