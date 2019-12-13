import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeveloperJdbcDemo {
//    http://www.javenue.info/post/java-jdbc-api
//    https://proselyte.net/tutorials/jdbc/simple-application-example/
//    https://proselyte.net/tutorials/java9/

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/proselyte";

    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        System.out.println("Executing statement...");

        statement = connection.createStatement();
    }
}
