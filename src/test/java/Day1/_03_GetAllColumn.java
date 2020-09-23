package Day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class _03_GetAllColumn {

    private Connection connection; // With a connection I am able to connect to my Database need to provide URL , username , password
    private Statement statement;  //  Once you have a Java Statement instance you can execute either a database
    // query or an database update with it.

    @BeforeClass
    public void beforeClass() throws SQLException {
        String URL ="jdbc:mysql://test.medis.mersys.io:3306/sakila";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(URL,username,password);
        statement = connection.createStatement();
    }

    @AfterClass
    public void disconnect() throws SQLException {
        connection.close();
    }

    @Test
    public void test1() throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT * FROM customer;");

//        if there is a next row then navigate to there.
        while(rs.next()){

            String firstName = rs.getString("first_name");
            String email = rs.getString(5);

            System.out.println("firstName --> " + firstName + " ---" + " email -->  "+ email);

        }

    }

    // Get only name column in the category table and print all the data in that column

}
