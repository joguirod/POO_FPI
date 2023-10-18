package ExercicioExtra01.questao06;

import ExercicioExtra01.questao02.Person;
import ExercicioExtra01.questao03.Employee;
import ExercicioExtra01.questao04.Professor;
import ExercicioExtra01.questao05.Payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PayrollApp {
    static Scanner scanner = new Scanner(System.in);
    static List<Person> persons = new ArrayList<Person>();

    public static void main(String[] args) {
        int choosenOption;
        do {
            System.out.println(options());
            choosenOption = scanner.nextInt();
            switch (choosenOption){
                case 1:
                    addPerson();
                case 2:
            }
        } while(choosenOption != 0);
    }

    public static String options(){
        return "1 - Add person to system" +
                "\n2 - Calculate all salary payments" +
                "\n0 - Leave";
    }

    public static void addPerson(){
        System.out.println("> Insert the person type:");
        System.out.println("\tP - Person\tE - Employee\tP - Professor");
        String type = scanner.next();

        System.out.println("> Name: ");
        String name = scanner.next();
        System.out.println("> Last Name: ");
        String lastName = scanner.next();

        if(type.equals("P")){
            Person person = new Person(name, lastName);
            persons.add(person);
            return;
        } else{
            System.out.println("> Registration: ");
            String registration = scanner.next();
            System.out.println("> Salary: ");
            double salary = scanner.nextDouble();
            if(type.equals("E")){
                Employee employee = new Employee(name, lastName, registration, salary);
                persons.add(employee);
            } else {
                System.out.println("> Title: ");
                String title = scanner.next();
                Professor professor = new Professor(name, lastName, registration, salary, title);
                persons.add(professor);
            }
        }
    }
}
