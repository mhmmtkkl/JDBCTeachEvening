package Day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_AbsuluteRelative {


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
    public void testAbsolute() throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT * FROM film_text;");

        /*
            rs.absolute(5);
                Instead of typing rs.next 5 times we can type  rs.absolute(5); and it will navigate to 5th location directly

         */
        rs.absolute(5);

        // get the title and description from the 5th row
        String title = rs.getString("title");
        String description = rs.getString("description");

        System.out.println(title +" -- " + description);

        String filmID = rs.getString("film_id");
        System.out.println("film ID 1 -->  "+filmID);

        String filmID2 = rs.getString(1);
        System.out.println("film ID 2 -->  "+filmID2);

        int filmIDInt = rs.getInt(1);
        System.out.println("film ID INT --> "+filmIDInt);

     //   int title5 = rs.getInt(2); // int i1 = "AFRICAN EGG"; exception name is NumberFormatException
     //   System.out.println(title5);


    }


}
