package Exercicio04.classes.Equipamento;

public class TestaEquipamento {
    public static void main(String[] args) {
        Equipamento furadeira = new Equipamento(true);
        
        System.out.printf("A furadeira está: %s.\n", furadeira.estaLigado() ? "ligada" : "desligada");

        furadeira.inverte();

        System.out.printf("A furadeira está: %s.\n", furadeira.estaLigado() ? "ligada" : "desligada");

        furadeira.desliga();

        System.out.printf("A furadeira está: %s.\n", furadeira.estaLigado() ? "ligada" : "desligada");

        furadeira.liga();

        System.out.printf("A furadeira está: %s.\n", furadeira.estaLigado() ? "ligada" : "desligada");

    }
}
