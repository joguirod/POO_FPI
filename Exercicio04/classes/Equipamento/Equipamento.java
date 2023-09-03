package classes.Equipamento;

public class Equipamento {
    boolean ligado;
    
    public Equipamento(boolean ligado){
        this.ligado = ligado;
    }

    public void liga() {
        if (!ligado){
            ligado = true;
        }
    }
    
    public void desliga() {
        if (ligado){
            ligado = false;
        }
    }   

    public void inverte() {
        ligado = !ligado;
    }

    public boolean estaLigado() {
        return ligado;
    }

}
