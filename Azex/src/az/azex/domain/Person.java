package az.azex.domain;

import java.io.Serializable;

public class Person extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 684753671729175736L;
    private String name;
    private String surname;

    public Person(long id, String name, String surname) {
        super(id, Status.ACTIVE);
        this.name = name;
        this.surname = surname;
    }

    public Person() {
        this.name = "";
        this.surname = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status=" + status +
                '}';
    }
}
