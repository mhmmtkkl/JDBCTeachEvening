package Day2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;

public class ReusableMethods {

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

    // method Name should be get query , which column  return an arrayList

    public ArrayList<String> getAllColumn(String query , int whichColumn ) throws SQLException {
        ResultSet rs = statement.executeQuery(query);

        ArrayList<String> result = new ArrayList<>();

        while(rs.next()){

            String data = rs.getString(whichColumn);

            result.add(data);

        }

        return result;

    }

    // in the language table get the name column
    


//    public void Task1() throws SQLException {
//        ResultSet rs = statement.executeQuery("SELECT name FROM category;");
//
//        while(rs.next()){
//            String name = rs.getString(1);
//            System.out.println(name);
//        }
//    }
}
