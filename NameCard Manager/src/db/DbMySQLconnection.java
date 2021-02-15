package db;

import db.dbServcie.DbMySQLconnectionServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbMySQLconnection implements DbMySQLconnectionServer {

    public Connection getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/databasename";
        String username = "root";
        String password = "1234";

        Class.forName(driver).newInstance();
        return DriverManager.getConnection(url, username, password);
    }

    public void saveRow() throws Exception{

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO table(col1, col2) VALUES(?, ?)")) {
            pstmt.setString(1, "value1");
            pstmt.setString(2, "value2");
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void getRow() {
        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM table");
            ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
                String col1Value = rs.getString("col1");
                // NameCard nameCard = new NameCard();
                // nameCard.setCompany(rs.getString("comapny"));
            }
        } catch (Exception e) {
        }
    }
}
