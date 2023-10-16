package Exercicio07.questao04.CopiaApp.Banco;

import Exercicio04.classes.Conta.Conta;
import Exercicio07.questao04.Poupanca;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<Conta>();

    public List<Conta> getContas() {
        return contas;
    }

    public void inserir(Conta conta){
        if (consultar(conta.getNumero()) == null){
            contas.add(conta);
        }

    }

    public Conta consultar(String numero){
        Conta contaProcurada = null;

        for (int i = 0; i < contas.size(); i++){
            if (contas.get(i).getNumero().equals(numero)) {
                contaProcurada = contas.get(i);
                break;
            }
        }
        return contaProcurada;
    }

    private int consultarPorIndice(String numero){
        int indiceProcurado = -1;

        for(int i = 0; i < contas.size(); i++){
            if (contas.get(i).getNumero().equals(numero)){
                indiceProcurado = i;
                break;
            }
        }
        return indiceProcurado;
    }

    public void alterar(Conta conta){
        int indiceProcurado = consultarPorIndice(conta.getNumero());

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
        Conta contaProcurada = consultar(numero);

        if(contaProcurada != null){
           contaProcurada.sacar(valor);
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

    public void renderJuros(String numero){
        Conta contaDesejada = consultar(numero);
        if(contaDesejada != null && contaDesejada instanceof Poupanca){
            ((Poupanca)contaDesejada).renderJuros();
        }
    }
}

