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

    //grouping 아직
    @Override
    public List<NameCardVO> groupingByCompany(String companyNameForGrouping) {
        List<NameCardVO> groupingList = null;

        return groupingList;
    }

    @Override
    public List<List<NameCardVO>> ascendingByName() {
        NameCardVO ascendingNameCardVO = new NameCardVO();
        List<NameCardVO> ascendingNameCardList = new ArrayList<>();
        ArrayList<String> workerNameList = new ArrayList<String>();

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
            ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
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

                ascendingNameCardList.add(ascendingNameCardVO);
                workerNameList.add(workerName);
            }
        } catch (Exception e) {
        }

        List<List<NameCardVO>> showAscending = new ArrayList<>();
        Collections.sort(workerNameList);
        for (String workername : workerNameList) {
            for (NameCardVO nameCardVO : ascendingNameCardList) {
                if (nameCardVO.getWorkerName().equalsIgnoreCase(workername)){
                    showAscending.add(ascendingNameCardList);
                }
            }
        }

        return showAscending;
    }

    @Override
    public List<List<NameCardVO>> descendingByName() {
        NameCardVO descendingNameCardVO = new NameCardVO();
        List<NameCardVO> descendingNameCardList = new ArrayList<>();
        ArrayList<String> workerNameList = new ArrayList<String>();

        try(Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
            ResultSet rs = pstmt.executeQuery()) {

            while(rs.next()) {
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
                workerNameList.add(workerName);
            }
        } catch (Exception e) {
        }

        List<List<NameCardVO>> showDescending = new ArrayList<>();
        Collections.sort(workerNameList, new DescendingInteger());
        for (String workername : workerNameList) {
            for (NameCardVO nameCardVO : descendingNameCardList) {
                if (nameCardVO.getWorkerName().equalsIgnoreCase(workername)){
                    showDescending.add(descendingNameCardList);
                }
            }
        }

        return showDescending;
    }



    private class DescendingInteger implements Comparator<String> {
        public int compare(String a, String b) {
            return b.compareTo(a);
        }

    }
}
