package ExercicioExtra01.questao02;

public class Person {
    private String _name;
    private String _lastName;

    public Person(String name, String lastName) {
        this._name = name;
        this._lastName = lastName;
    }

    public String nomeCompleto(){
        return _name + " " + _lastName;
    }
    public String get_name() {
        return _name;
    }

    public String get_lastName() {
        return _lastName;
    }
}
