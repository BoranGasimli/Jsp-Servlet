package az.azex.service.implementation;

import az.azex.domain.Person;
import az.azex.service.PersonService;
import az.azex.repository.PersonDao;

import java.util.List;
import java.util.Optional;

public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> getPersonList() {
        return personDao.getPersonList();
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        return personDao.getPersonById(id);
    }

    @Override
    public Person addPerson(Person person) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }

    @Override
    public boolean deletePerson(Person person) {
        return false;
    }
}
