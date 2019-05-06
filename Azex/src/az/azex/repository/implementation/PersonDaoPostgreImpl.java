package az.azex.repository.implementation;

import az.azex.domain.Person;
import az.azex.domain.Status;
import az.azex.utility.JdbcUtility;
import az.azex.repository.PersonDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDaoPostgreImpl implements PersonDao {

    private DataSource dataSource;

    public PersonDaoPostgreImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> getPersonList() {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Person> personList = new ArrayList<>();

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_PERSON_LIST);
            rs = ps.executeQuery();
            while(rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setStatus(Status.fromValue(rs.getInt("status")));
                personList.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }
        return personList;
    }

    @Override
    public Optional<Person> getPersonById(long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Optional<Person> optionalPerson = Optional.empty();

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_PERSON_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setStatus(Status.fromValue(rs.getInt("status")));
                optionalPerson = Optional.of(person);
                System.out.println("id = " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }

        return optionalPerson;
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
