package AtividadeAvaliativa01;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<Conta>();

    public List<Conta> getContas() {
        return contas;
    }

    public void inserir(Conta conta){

        // 13ª questão:
        try{
            consultar(conta.getNumero());
        } catch (ContaInexistenteError contaInexistente){
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

        // 8ª Questão: adição do ContaInexistenteError ao método
        if(contaProcurada == null){
            throw new ContaInexistenteError("A conta procurada é inexistente!");
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

        // 8ª Questão: adição do ContaInexistenteError ao método
        if(indiceProcurado == -1){
            throw new ContaInexistenteError("A conta procurada é inexistente!");
        }

        return indiceProcurado;
    }

    public void alterar(Conta conta){
        int indiceProcurado = consultarPorIndice(conta.getNumero());

        /*
        9ª questão: remoção dos ifs (Deixando o if comentado para mostrar como era antes)
        if (indiceProcurado != -1){
            contas.set(indiceProcurado, conta);
        }
        */
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

    public void depositar(String numero, double valor){
        Conta contaProcurada = consultar(numero);
        contaProcurada.depositar(valor);

        /*
        9ª questão: remoção dos ifs (Deixando o if comentado para mostrar como era antes)
        if(contaProcurada != null){
           contaProcurada.depositar(valor);
        }
        */
    }

    public void sacar(String numero, double valor){
        Conta contaProcurada = consultar(numero);
        contaProcurada.sacar(valor);

        /*
        9ª questão: remoção dos ifs (Deixando o if comentado para mostrar como era antes)
        if(contaProcurada != null){
           contaProcurada.sacar(valor);
        }
        */
    }

    public void transferir(String numDestino, String numOrigem, double valor){
        Conta contaDestino = consultar(numDestino);
        Conta contaOrigem = consultar(numOrigem);
        contaOrigem.transferir(contaDestino, valor);

        /*
        9ª questão: remoção dos ifs (Deixando o if comentado para mostrar como era antes)

        if(contaDestino != null && contaOrigem != null){
            contaOrigem.transferir(contaDestino, valor);
        }

        */
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

        /*
        9ª questão remoção dos ifs, nesse método apenas removi do if a verificação contaDesejada != null,
         mantendo a verificação para ver se a conta informada é uma poupança.
        */

        // 12ª questão - adição e implementação de PoupancaInvalidaError:
        if(!(contaDesejada instanceof Poupanca)){
            throw new PoupancaInvalidaError("A conta informada não é uma poupança!");
        }

        ((Poupanca)contaDesejada).renderJuros();
    }
}

