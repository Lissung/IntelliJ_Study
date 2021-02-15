package model.modelmpl;

import db.DbMySQLconnection;
import db.dbServcie.DbMySQLconnectionServer;
import model.modelService.ListingUpService;
import vo.NameCardVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ListingUpImpl implements ListingUpService {

    public Connection getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/namecardmanager_db";
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

    private static ListingUpImpl instance;

    public static ListingUpImpl getInstance(){

        if(instance==null){
            instance = new ListingUpImpl();
        }
        return instance;

    }

    @Override
    public List<NameCardVO> groupingByCompany(String companyNameForGrouping) {
        List<NameCardVO> groupingList = null;

        return groupingList;
    }

    @Override
    public List<NameCardVO> ascendingByName() {
        List<NameCardVO> ascendingList = null;

        return null;
    }

    @Override
    public List<NameCardVO> descendingByName() {
        List<NameCardVO> descendingList = null;

        return null;
    }
}
