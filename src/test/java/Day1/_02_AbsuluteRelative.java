package Day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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

    


}
