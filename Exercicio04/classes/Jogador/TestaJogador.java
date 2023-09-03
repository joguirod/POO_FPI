package classes.Jogador;

public class TestaJogador {
    public static void main(String[] args) {
        Jogador Neymar = new Jogador(20, 10, 200);
        Jogador SergioRamos = new Jogador(30, 4, 200);

        System.out.println("------- Neymar -------");
        System.out.println(Neymar.ToString());
        System.out.println("------- Sergio Ramos -------");
        System.out.println(SergioRamos.ToString());
        System.out.println("---------- DRIBLE HUMILHANTE ----------");

        SergioRamos.atacar(Neymar);
        Neymar.atacar(SergioRamos);

        System.out.println("------- Neymar -------");
        System.out.println(Neymar.ToString());
        System.out.println("------- Sergio Ramos -------");
        System.out.println(SergioRamos.ToString());

    }
}
