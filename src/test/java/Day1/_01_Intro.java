package Day1;

import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.Statement;


public class _01_Intro {

    /*
        What is JDBC ?

        JDBC(JAVA DATABASE CONNECTION)
        JDBC help me to automate mysql database.

       I am sending the query and getting the data from the database and make it is matching with expected result.


     */

    /*
        Usually in the interview they can ask about connection statement and result set



     */

    private Connection connection; // With a connection I am able to connect to my Database need to provide URL , username , password
    private Statement statement;  //  Once you have a Java Statement instance you can execute either a database
                                    // query or an database update with it.



    @BeforeClass
    public void beforeClass(){
        String URL ="jdbc:mysql://test.medis.mersys.io:3306/sakila";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        

    }


}
