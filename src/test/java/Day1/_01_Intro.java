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

        // rs.getString("first_name");  --> it is taking the data from the first_name column
        String firstName = rs.getString("first_name");

        System.out.println(firstName);

        rs.next();

        firstName = rs.getString("first_name");

        System.out.println(firstName);

    }

    /*
        Get all the data from the language table

        print 1.
              2.
              3.
              name from the table

     */

    @Test
    public void Task1() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM language;");

        rs.next();
        String name1 = rs.getString("name");
        System.out.println(name1);

        rs.next();
        String name2 = rs.getString("name");
        System.out.println(name2);

        rs.next();
        String name3 = rs.getString("name");
        System.out.println(name3);

    }

    @Test
    public void AlternativeTask1() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM language;");

         rs.next();
        // rs.getString(2);  in the pharanthesis we can mention the column name and also we can mention the
        // location of the column.
        String name1 = rs.getString(2);
        System.out.println(name1);

        rs.next();
        // rs.getString(2);  in the pharanthesis we can mention the column name and also we can mention the
        // location of the column.
        String name2 = rs.getString(2);
        System.out.println(name2);

        rs.next();
        // rs.getString(2);  in the pharanthesis we can mention the column name and also we can mention the
        // location of the column.
        String name3 = rs.getString(2);
        System.out.println(name3);


        /*
            With a .next() we can navigate forward in the table
            With a .previous() we can navigate to backward.
         */

        rs.previous();
        String name4 = rs.getString(2);
        System.out.println(name4);

    }


}









