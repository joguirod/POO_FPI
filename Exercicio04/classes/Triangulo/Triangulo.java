package classes.Triangulo;

public class Triangulo {
    int lado1;
    int lado2;
    int lado3;

    public Triangulo(int lado1, int lado2, int lado3){
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public boolean formaTriangulo() {
        return  lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1;
    }

    public boolean ehIsoceles(){
        if(!formaTriangulo()){
            return false;
        }
        return ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)) && (!ehEquilatero());
    }

    public boolean ehEquilatero(){
        if(!formaTriangulo()){
            return false;
        }
        return (lado1 == lado2) && (lado1 == lado3);
    }

    public boolean ehEscaleno(){
        if(!formaTriangulo()){
            return false;
        }
        return (lado1 != lado2) && (lado1 != lado3) && (lado2 != lado3);
    }

    public void mostrarCaracteristica() {
        String formaTrianguloString = this.formaTriangulo() ? "Sim" : "Não";
        String isoscelesString = this.ehIsoceles() ? "Sim" : "Não";
        String equilateroString = this.ehEquilatero() ? "Sim" : "Não";
        String escalenoString = this.ehEscaleno() ? "Sim" : "Não";

        System.out.println("---------------------------------------------");
        System.out.printf("Forma triângulo? %s\n", formaTrianguloString);
        System.out.printf("É isosceles? %s\n", isoscelesString);
        System.out.printf("É equilátero? %s\n", equilateroString);
        System.out.printf("É escaleno? %s\n", escalenoString);
        System.out.println("---------------------------------------------");

    }
}
