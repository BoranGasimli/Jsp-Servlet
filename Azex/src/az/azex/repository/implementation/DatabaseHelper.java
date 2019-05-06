package az.azex.repository.implementation;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DatabaseHelper {

    public static Connection connect() throws Exception {
        Context initialContext = new InitialContext();
        DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/azex");
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() throws Exception {
        Context initialContext = new InitialContext();
        DataSource dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/azex");
        return dataSource;
    }
}
