package Exercicio05.MicroBlog;

public class Postagem {
    int id;
    String texto;
    int quantidadeCurtidas;

    public void curtir(){
        quantidadeCurtidas += 1;
    }

    public String toString(){
        return texto +
        "\nCurtidas: " + quantidadeCurtidas;
    }
}