import az.azex.domain.Person;
import az.azex.service.PersonService;
import az.azex.service.implementation.PersonServiceImpl;
import az.azex.repository.PersonDao;
import az.azex.repository.implementation.DatabaseHelper;
import az.azex.repository.implementation.PersonDaoPostgreImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "DatabaseServlet", urlPatterns = "/db")
public class DatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();

            PersonDao personDao = new PersonDaoPostgreImpl(DatabaseHelper.getDataSource());
            PersonService personService = new PersonServiceImpl(personDao);

            List<Person> personList = new ArrayList<>();
            if(request.getParameter("id") != null) {
                Long id = Long.parseLong(request.getParameter("id"));
                Optional<Person> optionalPerson = personService.getPersonById(id);
                if(optionalPerson.isPresent()) {
                    System.out.println("person with id  exists ");
                    personList.add(optionalPerson.get());
                } else {
                    System.out.println("person with id = " + id + " does not exist");
                }
            } else {
                personList = personService.getPersonList();
            }

            personList.forEach(out::println);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {


        }
    }
}