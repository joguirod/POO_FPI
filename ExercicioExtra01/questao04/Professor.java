package ExercicioExtra01.questao04;

import ExercicioExtra01.questao03.Employee;

public class Professor extends Employee {
    private String _title;

    public Professor(String name, String lastName, String registration, double salary, String _title) {
        super(name, lastName, registration, salary);
        this._title = _title;
    }


    @Override
    public double calculateFirstSalaryQuota(){
        return getSalary();
    }

    @Override
    public double calculateSecondSalaryQuota(){
        return 0;
    }
}
