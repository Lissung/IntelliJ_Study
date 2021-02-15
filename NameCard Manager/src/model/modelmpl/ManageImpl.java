package model.modelmpl;

import model.modelService.ManageService;
import vo.NameCardVO;
import vo.UserVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ManageImpl implements ManageService {


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

    private static ManageImpl instance;

    public static ManageImpl getInstance(){

        if(instance==null){
            instance = new ManageImpl();
        }
        return instance;

    }

    @Override
    public void searchingCard() {

    }

    @Override
    public void listingUpCard() {

    }

    @Override
    public void addingCard() {

    }

    @Override
    public int searchByCompanyName(String companyName) {
        int isComName = 0;


        return isComName;
    }

    public int searchByWorkerName(String workerName) {
        int isComName = 0;


        return isComName;
    }

    public int searchByPhoneNumber(String phoneNumber) {
        int isComName = 0;


        return isComName;
    }

    @Override
    public NameCardVO editingContent(String subjectToEdit) {
        NameCardVO nameCardVO_edit = new NameCardVO();

        return nameCardVO_edit;
    }

    @Override
    public NameCardVO showingResult_Company(String input) {
        NameCardVO nameCardVO = new NameCardVO();

        return nameCardVO;
    }

    @Override
    public NameCardVO showingResult_Worker(String input) {
        NameCardVO nameCardVO = new NameCardVO();

        return nameCardVO;
    }

    public NameCardVO showingResult_PhoneNum(String input){
        NameCardVO nameCardVO = new NameCardVO();

        return nameCardVO;
    }


    //adding
    @Override
    public NameCardVO addingNewNameCard(String companyName, String workerName, String position,
                                  String locationOfCompany, Integer phoneNumber) {

        NameCardVO addNameCardVO = new NameCardVO();

        return addNameCardVO;
    }


}
