package Day1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.*;

public class _02_AbsuluteRelative {

    /*
    Absolute and relative

    Absolute is jumps to exact location
    relative is taking the current row + number in the parenthesis
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


        /*
            If you use multiuple absolute
            rs.absolute(5);  --> navigate to 5th location in the table
            rs.absolute(8);  --> navigate to 8th location in the table

         */
        rs.absolute(8);
        String filmID4 = rs.getString("title");
        System.out.println("film ID 4 -->  "+filmID4);
    }

    @Test
    public void relativeExample() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM city;");

        rs.relative(5);
        String cityName = rs.getString(2);
        System.out.println(cityName);

        // in the absolute if I need to jump to 11 th location then I need to use rs.absolute(11)
        // in the relative if I need to jump to 11 th location then I need to use rs.relative(6);
        // relative works as 5(current Row)+6(row in the parenthesis)

        rs.relative(6);
        String cityName2 = rs.getString(2);
        System.out.println(cityName2);
    }

    @Test
    public void lastFirstKeyword() throws SQLException {

        ResultSet rs = statement.executeQuery("SELECT * FROM city;");

        rs.last();//this will navigate to last row in the table

        String cityName = rs.getString("city");
        String countryID = rs.getString("country_id");

        System.out.println(cityName + " -- " + countryID);

        rs.first(); // this will navigate to first row in the table
        String firstCityName = rs.getString("city");
        System.out.println(firstCityName);

    }


    /*
        Get the address , district in the 10th row , 22th and last row in the address table
     */

    @Test
    public void Task1() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT address, district FROM address;");

        rs.relative(10);
        String address = rs.getString("address");
        String district = rs.getString("district");

        System.out.println("address 10th --> " + address + "  ---  " +"district  --> " + district);

        rs.relative(12);
        String address2 = rs.getString("address");
        String district2 = rs.getString("district");

        System.out.println("address 22th --> " + address2 + "  ---  " +"district  --> " + district2);

        rs.last();
        String address3 = rs.getString("address");
        String district3 = rs.getString("district");

        System.out.println("address last --> " + address3 + "  ---  " +"district  --> " + district3);

    }


}
