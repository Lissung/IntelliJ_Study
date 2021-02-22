package model.modelmpl;

import constant.Constant;
import model.modelService.SignUpService;
import vo.UserVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SignUpImpl implements SignUpService {

    public Connection getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/namecardmanager_db?serverTimezone=Asia/Seoul";
        String username = "root";
        String password = "1234";

        Class.forName(driver).newInstance();
        return DriverManager.getConnection(url, username, password);
    }

    public void saveRow() throws Exception {
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO table(col1, col2) VALUES(?, ?)")) {
            pstmt.setString(1, "value1");
            pstmt.setString(2, "value2");
            pstmt.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void getRow() {
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM table");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String col1Value = rs.getString("col1");
                // NameCard nameCard = new NameCard();
                // nameCard.setCompany(rs.getString("comapny"));
            }
        } catch (Exception e) {
        }
    }

    private static SignUpImpl instance;

    public static SignUpImpl getInstance() {

        if (instance == null) {
            instance = new SignUpImpl();
        }
        return instance;

    }

    @Override
    public int checkSignUpID(String signUpID) {

        List<UserVO> userVOList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM userslist");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String userID = rs.getString("UserID");
                UserVO checkUser = new UserVO();
                checkUser.setUserID(userID);
                userVOList.add(checkUser);
                // NameCard nameCard = new NameCard();
                // nameCard.setCompany(rs.getString("comapny"));
            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        int isIdExist_ = 0;
        if(userVOList.size()==0){
            isIdExist_= Constant.ID_Available;
        }
        for (UserVO userVO : userVOList) {
            if (signUpID.equalsIgnoreCase(userVO.getUserID())) {
                isIdExist_ = Constant.ID_Unavailable;
            } else isIdExist_ = Constant.ID_Available;
        }
        return isIdExist_;
    }

    @Override
    public void setSignUpID(String signUpID, String signUpPWD) throws Exception {
            try (Connection connection = getConnection();
                 PreparedStatement pstmt = connection.prepareStatement("INSERT INTO userslist(UserID, UserPWD) VALUES(?, ?)")) {
                pstmt.setString(1, signUpID);
                pstmt.setString(2, signUpPWD);
                pstmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("SignUp Error : " + e);
            }
    }


}
