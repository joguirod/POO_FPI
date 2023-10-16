package Exercicio04.classes.Conta;

public class Conta {
    private String _numero;
    private String _titular;
    private double _saldo;

    public Conta(String numero, double saldo){
        _numero = numero;
        _saldo = saldo;
    }

    public Conta(String numero, String titular, double saldo){
        _numero = numero;
        _titular = titular;
        _saldo = saldo;
    }

    public boolean sacar(double valor){
        if (_saldo < 0 || _saldo - valor < 0){
            return false;
        }
        
        _saldo -= valor;
        return true;
    }

    public void depositar(double valor){
        _saldo += valor;
    }

    public double consultarSaldo(){
        return this._saldo;
    }

    public boolean transferir(Conta ContaDestino, double valor){
        if (_saldo < 0 || _saldo - valor < 0){
            return false;
        }

        this.sacar(valor);
        ContaDestino.depositar(valor);
        return true;
    }

    public String getNumero() {
        return _numero;
    }

    public String getTitular() {
        return _titular;
    }

    public double getSaldo() {
        return _saldo;
    }


}
