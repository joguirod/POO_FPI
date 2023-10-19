package ExercicioExtra01.questao02;

public class Person {
    private String _name;
    private String _lastName;

    public Person(String name, String lastName) {
        this._name = name;
        this._lastName = lastName;
    }

    public String fullName(){
        return _name + " " + _lastName;
    }
    public String getName() {
        return _name;
    }

    public String getLastName() {
        return _lastName;
    }
}
