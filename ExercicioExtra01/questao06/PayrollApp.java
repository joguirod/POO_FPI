package ExercicioExtra01.questao06;

import Exercicio07.questao04.CopiaApp.App;
import ExercicioExtra01.questao02.Person;
import ExercicioExtra01.questao03.Employee;
import ExercicioExtra01.questao04.Professor;
import ExercicioExtra01.questao05.Payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PayrollApp {

    // App criado para testar os métodos das classe
    static Scanner scanner = new Scanner(System.in);
    static List<Person> persons = new ArrayList<Person>();
    static Payroll payroll = new Payroll(persons);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choosenOption;
        do {
            System.out.println(options());
            choosenOption = scanner.nextInt();
            myCtrlL();

            switch (choosenOption){
                case 1:
                    addPerson();
                    break;
                case 2:
                    System.out.println("Total payments: U$" + payroll.calculateTotalPayments());
                    break;
                case 3:
                    showEmployeeSalary();
                    break;
                case 0:
                    System.out.println("Good bye :)");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }

            myContinue();
        } while(choosenOption != 0);
        scanner.close();
    }

    public static String options(){
        return "1 - Add person to system" +
                "\n2 - Calculate all salary payments" +
                "\n3 - Show each employee salary" +
                "\n0 - Leave";
    }

    public static void addPerson(){
        System.out.println("> Insert the person type:");
        System.out.println("\tP - Person\tE - Employee\tPR - Professor");
        String type = scanner.next();

        System.out.println("> Name: ");
        String name = scanner.next();
        System.out.println("> Last Name: ");
        String lastName = scanner.next();

        if(type.equals("P")){
            Person person = new Person(name, lastName);
            payroll.addPerson(person);
            return;
        } else{
            System.out.println("> Registration: ");
            String registration = scanner.next();
            System.out.println("> Salary: ");
            double salary = scanner.nextDouble();
            if(type.equals("E")){
                Employee employee = new Employee(name, lastName, registration, salary);
                payroll.addPerson(employee);
            } else {
                System.out.println("> Title: ");
                String title = scanner.next();
                Professor professor = new Professor(name, lastName, registration, salary, title);
                payroll.addPerson(professor);
            }
            scanner.nextLine();
        }
    }

    public static void showEmployeeSalary(){
        for(Person person : persons){
            if(person instanceof Employee){
                System.out.println(person + "\n");
            }
        }
    }

    public static void myCtrlL(){
        System.out.println("\n".repeat(20));
    }

    public static void myContinue(){
        System.out.print("Press <anykey> to continue...");
        scanner.nextLine();
    }
}


