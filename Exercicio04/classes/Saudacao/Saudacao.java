package Exercicio04.classes.Saudacao;

public class Saudacao {
    String texto;
    String destinatario;

    Saudacao (String texto, String destinatario){
        this.texto = texto;
        this.destinatario = destinatario;
    }

    public String obterSaudacao(){
        return texto + destinatario;
    }
}