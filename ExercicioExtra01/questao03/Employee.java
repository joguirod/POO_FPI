package ExercicioExtra01.questao03;

import ExercicioExtra01.questao02.Person;

public class Employee extends Person {
    private String _registration;
    private double _salary;

    public Employee(String name, String lastName, String registration, double salary) {
        super(name, lastName);
    }

    public double calculateFirstSalaryQuota(){
        return _salary*0.6;
    }

    public double calculateSecondSalaryQuota(){
        return _salary*0.4;
    }

    public String getRegistration() {
        return _registration;
    }

    public double getSalary() {
        return _salary;
    }
}
