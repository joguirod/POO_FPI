package ExercicioExtra01.questao01;

public class Diarista extends Empregado {

    public Diarista(double salario) {
        super(salario);
    }

    @Override
    public double calcularSalario(){
        return super.calcularSalario()/30;
    }
}
