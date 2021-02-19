package model.modelmpl;

import constant.Constant;
import model.modelService.LogInService;
import vo.UserVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LogInImpl implements LogInService {

    public Connection getConnection() throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/namecardmanager_db";
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

    private static LogInImpl instance;

    public static LogInImpl getInstance() {

        if (instance == null) {
            instance = new LogInImpl();
        }
        return instance;

    }

    @Override
    public int checkUserID(String logInID, String logInPWD) {

        List<UserVO> userListToCheckLogin = new ArrayList<>();
        try (Connection connection   = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM userslist");
             ResultSet rs            = pstmt.executeQuery()) {

            while (rs.next()) {
                String userID   = rs.getString("UserID");
                String userPWD  = rs.getString("UserPWD");
                UserVO userList = new UserVO();
                userList.setUserID(userID);
                userList.setUserPWD(userPWD);
                userListToCheckLogin.add(userList);
            }
        } catch (Exception e) {
        }

        int isLogInID = 0;

        if(userListToCheckLogin.size()==0){
            isLogInID = Constant.id_Not_Exist;
        }
        for (UserVO userVO : userListToCheckLogin) {
            if (logInID.equalsIgnoreCase(userVO.getUserID())) {
                if (logInPWD.equalsIgnoreCase(userVO.getUserPWD())) {
                    isLogInID = Constant.logIN_Success;
                } else isLogInID = Constant.pwd_Is_Not_Correct;
            } else isLogInID = Constant.id_Not_Exist;
        }
        return isLogInID;
    }
}
