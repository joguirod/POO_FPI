package Exercicio04.classes.Triangulo;

public class TestandoTriangulo {
    public static void main(String[] args) {
        Triangulo trianguloImpossivel = new Triangulo(5, 5, 10);
        Triangulo trianguloIsosceles = new Triangulo(2, 2, 3);
        Triangulo trianguloEquilatero = new Triangulo(4, 4, 4);
        Triangulo trianguloEscaleno = new Triangulo(3, 4, 5);

        trianguloImpossivel.mostrarCaracteristica();
        trianguloIsosceles.mostrarCaracteristica();
        trianguloEquilatero.mostrarCaracteristica();
        trianguloEscaleno.mostrarCaracteristica();
    }
}
