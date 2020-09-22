package Day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;


public class _01_Intro {

    /*
        What is JDBC ?

        JDBC(JAVA DATABASE CONNECTION)
        JDBC help me to automate mysql database.

       I am sending the query and getting the data from the database and make it is matching with expected result.


     */

    /*
        Usually in the interview they can ask about connection statement and result set

        Interview

        Step by step JDBC connection?
            First I need my connection to my database I am providing the URL , Username , password
            Then I am creating statement to execute the queries.
            After I execute them I am storing my data in the resultSet
            I am using result set for testing.



     */

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
        // ResultSet -->  After send the query we need to store it in ResultSet so we can use it in the testing.
        ResultSet rs = statement.executeQuery("select * from actor;");

        /*
            After I get the data

            Result set locations is location 0 but my data base is starting from 1
            To make the result set location from 0 to 1 I need to use .next()
         */
        rs.next();

        //How to get the data from ResultSet
        String firstName = rs.getString("first_name");

        System.out.println(firstName);


    }

}









