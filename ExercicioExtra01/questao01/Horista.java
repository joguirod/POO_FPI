package ExercicioExtra01.questao01;

public class Horista extends Diarista {

    public Horista(double salario) {
        super(salario);
    }

    @Override
    public double calcularSalario(){
        return super.calcularSalario()/24;
    }
}
