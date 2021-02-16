package model.modelmpl;

import constant.Constant;
import model.modelService.ManageService;
import vo.NameCardVO;
import vo.UserVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

    private static ManageImpl instance;

    public static ManageImpl getInstance() {

        if (instance == null) {
            instance = new ManageImpl();
        }
        return instance;

    }
    //searching
    @Override
    public int searchByCompanyName(String companyName) {
        List<NameCardVO> nameCardVOList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            NameCardVO nameCardVO = new NameCardVO();
            while (rs.next()) {
                String companyNameCompare = rs.getString("companyName");
                nameCardVO.setCompanyName(companyNameCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
        }

        int isComName = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (companyName.equalsIgnoreCase(nameCardVO.getCompanyName())){
                isComName = Constant.is_CompanyName;
            } else isComName = Constant.is_Not_CompanyName;
        }
        return isComName;
    }
    public int searchByWorkerName(String workerName) {
        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            NameCardVO nameCardVO = new NameCardVO();
            while (rs.next()) {
                String workerNameCompare = rs.getString("workerName");
                nameCardVO.setWorkerName(workerNameCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
        }

        int isWorkerName = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (workerName.equalsIgnoreCase(nameCardVO.getWorkerName())){
                isWorkerName = Constant.is_Not_WorkerName;
            } else isWorkerName = Constant.is_WorkerName;
        }
        return isWorkerName;
    }
    public int searchByPhoneNumber(String phoneNumber) {
        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            NameCardVO nameCardVO = new NameCardVO();
            while (rs.next()) {
                int phoneNumberCompare = rs.getInt("phoneNumber");
                nameCardVO.setPhoneNumber(phoneNumberCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
        }

        int isPhonNumber = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (phoneNumber.equalsIgnoreCase(nameCardVO.getWorkerName())){
                isPhonNumber = Constant.is_Not_PhoneNumber;
            } else isPhonNumber = Constant.is_PhoneNumber;
        }
        return isPhonNumber;
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



    // Edit >> 얘를 하나의 클래스로 두고 instance로 불러오면 여러번 반복으로 할 때 데이터 덜 잡아 먹을 듯?
    @Override
    public NameCardVO selectSubjectToEdit(String subjectToEdit, Long detailsToEdit) {
        NameCardVO nameCardVO_edit = new NameCardVO();
        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                nameCardVO_edit.setPhoneNumber(phoneNumber);
                nameCardVO_edit.setWorkerName(workerName);
                nameCardVO_edit.setPosition(position);
                nameCardVO_edit.setLocationOfCompany(locationOfCompany);
                nameCardVO_edit.setCompanyName(companyName);

                nameCardVOList.add(nameCardVO_edit);
            }
        } catch (Exception e) {
        }

        for (NameCardVO nameCardVO : nameCardVOList) {
            // subject 찾는 메서드?
            // 이후 content 변경
        }

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

    public NameCardVO showingResult_PhoneNum(String input) {
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
