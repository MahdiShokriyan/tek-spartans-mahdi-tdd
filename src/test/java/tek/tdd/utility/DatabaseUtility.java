package tek.tdd.utility;

import tek.tdd.base.BaseSetup;

import java.sql.*;

public class DatabaseUtility extends BaseSetup {

    public ResultSet executeQuery(String query){
        try{
            String url = getProperties("db.url");
            String username = getProperties("db.username");
            String password = getProperties("db.password");
            Connection connection = DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
