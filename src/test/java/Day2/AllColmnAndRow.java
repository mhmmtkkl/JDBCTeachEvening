package Day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class AllColmnAndRow {

    private Connection connection; // With a connection I am able to connect to my Database need to provide URL , username , password
    private Statement statement;  //  Once you have a Java Statement instance you can execute either a database
    // query or an database update with it.

    @BeforeClass
    public void beforeClass() throws SQLException {
        String URL ="jdbc:mysql://test.medis.mersys.io:33306/sakila";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(URL,username,password);
        statement = connection.createStatement();
    }

    @AfterClass
    public void disconnect() throws SQLException {
        connection.close();
    }

    // get the data from actor table and print all the first name and last name


    @Test
    public void task1() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM actor;");

        while(rs.next()){

            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");

            System.out.println(firstName + " -- " + lastName);
        }

    }

//    I have 3 columns actorID , firstName , LastName
//     Print all the columns and all the row in the same time
    @Test
    public void test2() throws SQLException {

        ResultSet rs = statement.executeQuery("select language_id , name from language;");







    }

}
