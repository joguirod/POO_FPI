package classes.Jogador;

public class Jogador {
    int forca;
    int nivel;
    double pontosAtuais;

    public Jogador(int forca, int nivel, double pontosAtuais){
        this.forca = forca;
        this.nivel = nivel;
        this.pontosAtuais = pontosAtuais;
    }
    
    public boolean estaVivo(){
        return pontosAtuais > 0;
    }
    public void atacar(Jogador Atacado){
        if (Atacado.estaVivo() && Atacado != this){
            Atacado.pontosAtuais -= this.calcularAtaque();
        }
    }
    
    public String ToString(){
        String caracteristicas = "Força: " + forca;
        caracteristicas += "\nNível: " + nivel;
        caracteristicas += "\nPontos Atuais: " + pontosAtuais;
        return caracteristicas;
    }

    private int calcularAtaque(){
        return forca*nivel;
    }
    
}
