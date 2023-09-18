package Exercicio05.App.Banco;
import Exercicio04.classes.Conta.Conta;
import java.util.List;
import java.util.ArrayList;

public class Banco {
    public List<Conta> contas = new ArrayList<Conta>();

    public void inserir(Conta conta){
        if (consultar(conta.numero) == null){
            contas.add(conta);

        }
             
    }

    public Conta consultar(String numero){
        Conta contaProcurada = null;

        for (int i = 0; i < contas.size(); i++){
            if (contas.get(i).numero.equals(numero)) {
                contaProcurada = contas.get(i);
                break;
            }
        }
        return contaProcurada;
    }

    public int consultarPorIndice(String numero){
        int indiceProcurado = -1;

        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).numero == numero){
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado;
    }

    public void alterar(Conta conta){
        int indiceProcurado = consultarPorIndice(conta.numero);

        if (indiceProcurado != -1){
            contas.set(indiceProcurado, conta);
        }
    }

    public void excluir(String numero){
        int indiceProcurado = consultarPorIndice(numero);

        if(indiceProcurado != -1){
            for (int i = indiceProcurado; i < contas.size(); i++){
                contas.set(i, contas.get(i + 1));
            }
            contas.remove(contas.size() - 1);
        }
    }

    public void sacar(String numero, double valor){
        int indiceProcurado = consultarPorIndice(numero);

        if(indiceProcurado != -1){
            Conta conta = contas.get(indiceProcurado);
            conta.sacar(valor);
        }
    }

    public int qtdContas(){
        return contas.size();
    }

    public double totalDepositado(){
        double total = 0;

        for (Conta conta : contas) {
            total += conta.consultarSaldo();
        }

        return total;
    }

    public double mediaDepositado(){
        return totalDepositado() / qtdContas();
    }
}
