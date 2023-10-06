package Exercicio04.classes.Conta;

public class Conta {
    private String numero;
    private String titular;
    private double saldo;

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(String numero, String titular, double saldo){
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }


    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor){
        if (saldo < 0 || saldo - valor < 0){
            return false;
        }
        
        saldo -= valor;
        return true;
    }

    public void depositar(double valor){
        saldo += valor;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    public boolean transferir(Conta ContaDestino, double valor){
        if (saldo < 0 || saldo - valor < 0){
            return false;
        }

        this.sacar(valor);
        ContaDestino.depositar(valor);
        return true;
    }


}
