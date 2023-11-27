package AtividadeAvaliativa01;

public class Conta {
    private String _numero;
    private String _titular;
    private double _saldo;

    public Conta(String numero, double saldo) throws ValorInvalidoError{
        /*
        if(saldo < 0){

            06ª questão - lançamento no construtor
            throw new RuntimeException("Valor inválido! (menor do que 0)"); // 06ª questão - lançamento no construtor

            throw new ValorInvalidoError("Valor inválido! O valor deve ser maior do que 0.");
        }
        */

        // 11ª questão - adição do método validaValor:
        validaValor(saldo);

        _numero = numero;
        _saldo = saldo;
    }

    public Conta(String numero, String titular, double saldo) throws ValorInvalidoError{
        /*
        if(saldo < 0){

            06ª questão - lançamento no construtor
            throw new RuntimeException("Valor inválido! (menor do que 0)"); // 06ª questão - lançamento no construtor

            throw new ValorInvalidoError("Valor inválido! O valor deve ser maior do que 0.");
        }
        */

        // 11ª questão - adição do método validaValor:
        validaValor(saldo);

        _numero = numero;
        _titular = titular;
        _saldo = saldo;
    }

    public void sacar(double valor) throws ValorInvalidoError, SaldoInsuficienteError{

        /*
         3ª questão:
        if (this._saldo < valor){
            throw new RuntimeException("Saldo insuficiente");
        }
        if (valor < 0){

            06ª questão - valor menor do que 0
            throw new RuntimeException("Valor fornecido menor do que 0!");

            10ª questão - criação e implementação do ValorInvalidoError:
            throw new ValorInvalidoError("Valor inválido! O valor deve ser maior do que 0.");
        }
        */

        // 11ª questão: adição do método validaValor
        validaValor(valor);

        // 7ª questão não pedia, mas implementei SaldoInsuficienteError criada na mesma:
        if (this._saldo < valor){
            throw new SaldoInsuficienteError("Saldo insuficiente");
        }

        _saldo -= valor;
    }

    public void depositar(double valor) throws ValorInvalidoError, SaldoInsuficienteError{

        /*

        // 06ª questão - Valor menor do que 0
        if (valor < 0){

            06ª questão - valor menor do que 0
            throw new RuntimeException("Valor fornecido menor do que 0!");

            throw new ValorInvalidoError("Valor inválido! O valor deve ser maior do que 0.");
        }

         */

        // 11ª questão - adição do método validaValor:
        validaValor(valor);
        _saldo += valor;
    }

    public double consultarSaldo(){
        return this._saldo;
    }

    public void transferir(Conta ContaDestino, double valor) throws ValorInvalidoError, SaldoInsuficienteError{
        // 4 questão: if-else removido e método agora é void
        this.sacar(valor);
        ContaDestino.depositar(valor);
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

    private void validaValor(double valor) throws ValorInvalidoError{
        if(valor < 0){
            throw new ValorInvalidoError("Valor inválido! O valor deve ser maior do que 0 !");
        }
    }
}
