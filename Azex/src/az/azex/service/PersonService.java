package az.azex.service;

import az.azex.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> getPersonList();
    Optional<Person> getPersonById(long id);
    Person addPerson(Person person);
    Person updatePerson(Person person);
    boolean deletePerson(Person person);
}
