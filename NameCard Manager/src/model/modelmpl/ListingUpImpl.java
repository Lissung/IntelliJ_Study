package model.modelmpl;

import model.modelService.ListingUpService;
import vo.NameCardVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListingUpImpl implements ListingUpService {

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

    private static ListingUpImpl instance;

    public static ListingUpImpl getInstance() {

        if (instance == null) {
            instance = new ListingUpImpl();
        }
        return instance;

    }

    //grouping 아직
    @Override
    public List<NameCardVO> groupingByCompany(String companyNameForGrouping) {
        List<NameCardVO> groupingList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO groupingNameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                groupingNameCardVO.setPhoneNumber(phoneNumber);
                groupingNameCardVO.setWorkerName(workerName);
                groupingNameCardVO.setPosition(position);
                groupingNameCardVO.setLocationOfCompany(locationOfCompany);
                groupingNameCardVO.setCompanyName(companyName);

                groupingList.add(groupingNameCardVO);
            }
        } catch (Exception e) {
        }

        List<NameCardVO> resultGroupingByCompanyList = new ArrayList<>();
        for (NameCardVO nameCardVO : groupingList) {
            if (nameCardVO.getCompanyName().equalsIgnoreCase(companyNameForGrouping)) {
                resultGroupingByCompanyList.add(nameCardVO);
            }
        }
        return resultGroupingByCompanyList;
    }

    @Override
    public List<NameCardVO> ascendingByName() {

        List<NameCardVO> NameCardList = new ArrayList<>();
        ArrayList<String> workerNameList = new ArrayList<String>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO ascendingNameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                ascendingNameCardVO.setPhoneNumber(phoneNumber);
                ascendingNameCardVO.setWorkerName(workerName);
                ascendingNameCardVO.setPosition(position);
                ascendingNameCardVO.setLocationOfCompany(locationOfCompany);
                ascendingNameCardVO.setCompanyName(companyName);

                NameCardList.add(ascendingNameCardVO);
                workerNameList.add(workerName);
            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        List<NameCardVO> ascendingList = new ArrayList<>();
        Collections.sort(workerNameList);
        for (String workername : workerNameList) {
            for (NameCardVO nameCardVO : NameCardList) {
                if (nameCardVO.getWorkerName().equalsIgnoreCase(workername)) {
                    ascendingList.add(nameCardVO);
                }
            }
        }

        return ascendingList;
    }

    @Override
    public List<NameCardVO> descendingByName() {

        List<NameCardVO> descendingNameCardList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo ORDER BY workerName DESC");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO descendingNameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                descendingNameCardVO.setPhoneNumber(phoneNumber);
                descendingNameCardVO.setWorkerName(workerName);
                descendingNameCardVO.setPosition(position);
                descendingNameCardVO.setLocationOfCompany(locationOfCompany);
                descendingNameCardVO.setCompanyName(companyName);

                descendingNameCardList.add(descendingNameCardVO);
            }
        } catch (Exception e) {
        }
        return descendingNameCardList;
    }

}
