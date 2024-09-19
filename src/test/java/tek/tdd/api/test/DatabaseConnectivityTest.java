package tek.tdd.api.test;

import org.testng.annotations.Test;

import java.sql.*;

public class DatabaseConnectivityTest {


    @Test
    public void databaseConnectionTest() {
        //Step 1: Create Connection
        String url = "jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app";
        String username = "tek_student_user";
        String password = "FEB_2024";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            //Step 2: Create Statement
            Statement statement = connection.createStatement();
            //Step 3: execute Query
            ResultSet result = statement.executeQuery("SELECT * " +
                    "FROM tek_insurance_app.primary_person where id = 10107;");
            //Step 4: Get Result Set
            while (result.next()) {
                System.out.println(result.getString("email"));
                System.out.println(result.getInt("id"));
                System.out.println(result.getDate("date_of_birth"));
            }
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

}



