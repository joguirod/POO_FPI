package ExercicioExtra01.questao05;

import ExercicioExtra01.questao02.Person;
import ExercicioExtra01.questao03.Employee;
import ExercicioExtra01.questao04.Professor;

import java.util.List;
import java.util.ArrayList;
public class Payroll {
    List<Person> persons = new ArrayList<Person>();

    public Payroll(List<Person> persons){
        this.persons = persons;
    }

    public double calculateTotalPayments(){
        double total = 0;
        for(Person person : persons){
            if(person instanceof Employee){
                total += ((Employee) person).getSalary();
            }
        }
        return total;
    }
}
