import java.sql.*;

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

        String sql = "select * from developers";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("retrieving data from sql");

        System.out.println("\n Developers: ");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String speciality = resultSet.getString("speciality");
            int salary = resultSet.getInt("salary");

            System.out.println("\n================\n");
            System.out.println("id: " + id);
            System.out.println("Name: " + name);
            System.out.println("Specialty: " + speciality);
            System.out.println("Salary: $" + salary);
        }
        System.out.println("Closing connection...");

        resultSet.close();
        statement.close();
        connection.close();
    }
}
