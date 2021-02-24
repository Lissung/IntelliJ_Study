package model.modelmpl;

import constant.Constant;
import model.modelService.ManageService;
import vo.NameCardVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManageImpl implements ManageService {


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


            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                String companyNameCompare = rs.getString("companyName");
                nameCardVO.setCompanyName(companyNameCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }
        List<NameCardVO> searchedNameCardVOList = new ArrayList<>();
        int isComName = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (companyName.equalsIgnoreCase(nameCardVO.getCompanyName())) {
                searchedNameCardVOList.add(nameCardVO);
            }
            if (searchedNameCardVOList.isEmpty()) {
                isComName = Constant.is_Not_CompanyName;
            } else {
                isComName = Constant.is_CompanyName;
            }
        }
        return isComName;
    }

    public int searchByWorkerName(String workerName) {
        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {


            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                String workerNameCompare = rs.getString("workerName");
                nameCardVO.setWorkerName(workerNameCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        int isWorkerName = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (nameCardVOList.isEmpty()) {
                isWorkerName = Constant.is_Not_WorkerName;
            } else {
                isWorkerName = Constant.is_WorkerName;
            }
        }
        return isWorkerName;
    }

    public int searchByPhoneNumber(int phoneNumber) {
        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {


            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                int phonenumberCompare = rs.getInt("phoneNumber");
                nameCardVO.setPhoneNumber(phonenumberCompare);
                nameCardVOList.add(nameCardVO);
            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        int isPhoneNumber = 0;
        for (NameCardVO nameCardVO : nameCardVOList) {
            if (nameCardVOList.isEmpty()) {
                isPhoneNumber = Constant.is_Not_PhoneNumber;
            } else {
                isPhoneNumber = Constant.is_PhoneNumber;
            }
        }
        return isPhoneNumber;
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
    public NameCardVO selectSubjectToEdit(NameCardVO resultNameCardVO, int subjectToEdit, Long detailsToEdit) {

        List<NameCardVO> nameCardVOList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO nameCardVO_edit = new NameCardVO();
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
            System.out.println("SignUp Id Error : " + e);
        }

        // for (NameCardVO nameCardVO : nameCardVOList) {
        // if (resultNameCardVO.getWorkerName().equalsIgnoreCase(nameCardVO_edit.getWorkerName())) {
        switch (subjectToEdit) {
            case Constant.Edit_companyName:
                try (Connection connection = getConnection();
                     PreparedStatement pstmt = connection.prepareStatement(
                             "UPDATE namecardvo SET companyName = detailsToEdit WHERE workerName = resultNameCardVO.getWorkerName")) {
                    pstmt.executeUpdate();
                } catch (Exception e) {
                }
            case Constant.Edit_workerName:
            case Constant.Edit_position:
            case Constant.Edit_locationOfCompany:
            case Constant.Edit_phoneNumber:
        }
        // }
        //}

        return null;
    }


    @Override
    public List<NameCardVO> showingResult_Company(String inputCompanyName) {

        List<NameCardVO> showingResultList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                nameCardVO.setPhoneNumber(phoneNumber);
                nameCardVO.setWorkerName(workerName);
                nameCardVO.setPosition(position);
                nameCardVO.setLocationOfCompany(locationOfCompany);
                nameCardVO.setCompanyName(companyName);

                showingResultList.add(nameCardVO);

            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        List<NameCardVO> listOnCompanyName = new ArrayList<>();
        for (NameCardVO nameCarVO : showingResultList) {
            if (nameCarVO.getCompanyName().equalsIgnoreCase(inputCompanyName)) {
                listOnCompanyName.add(nameCarVO);
            }
        }
        return listOnCompanyName;
    }

    @Override
    public NameCardVO showingResult_Worker(String inputWorkerName) {
        List<NameCardVO> showingResultList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                nameCardVO.setPhoneNumber(phoneNumber);
                nameCardVO.setWorkerName(workerName);
                nameCardVO.setPosition(position);
                nameCardVO.setLocationOfCompany(locationOfCompany);
                nameCardVO.setCompanyName(companyName);

                showingResultList.add(nameCardVO);

            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        NameCardVO onWorkerName = new NameCardVO();
        for (NameCardVO nameCarVO : showingResultList) {
            if (nameCarVO.getWorkerName().equalsIgnoreCase(inputWorkerName)) {
                onWorkerName = nameCarVO;
            }
        }
        return onWorkerName;
    }

    public NameCardVO showingResult_PhoneNum(int inputPhoneNumber) {
        List<NameCardVO> showingResultList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM namecardvo");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                NameCardVO nameCardVO = new NameCardVO();
                int phoneNumber = rs.getInt("phoneNumber");
                String workerName = rs.getString("workerName");
                String position = rs.getString("position");
                String locationOfCompany = rs.getString("locationOfCompany");
                String companyName = rs.getString("companyName");

                nameCardVO.setPhoneNumber(phoneNumber);
                nameCardVO.setWorkerName(workerName);
                nameCardVO.setPosition(position);
                nameCardVO.setLocationOfCompany(locationOfCompany);
                nameCardVO.setCompanyName(companyName);

                showingResultList.add(nameCardVO);

            }
        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        NameCardVO onPhoneNumber = new NameCardVO();
        for (NameCardVO nameCarVO : showingResultList) {
            if (nameCarVO.getPhoneNumber().equals(inputPhoneNumber)) {
                onPhoneNumber = nameCarVO;
            }
        }
        return onPhoneNumber;
    }


    //adding
    @Override
    public NameCardVO addingNewNameCard(String companyName, String workerName, String position,
                                        String locationOfCompany, Integer phoneNumber) {


        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO namecardvo(companyName, workerName, position, locationOfCompany, phoneNumber) " +
                             "VALUES(?, ?, ?, ?, ?)")) {
            pstmt.setString(1, companyName);
            pstmt.setString(2, workerName);
            pstmt.setString(3, position);
            pstmt.setString(4, locationOfCompany);
            pstmt.setInt(5, phoneNumber);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("SignUp Id Error : " + e);
        }

        NameCardVO addNameCardVO = new NameCardVO();

        addNameCardVO.setPhoneNumber(phoneNumber);
        addNameCardVO.setWorkerName(workerName);
        addNameCardVO.setPosition(position);
        addNameCardVO.setLocationOfCompany(locationOfCompany);
        addNameCardVO.setCompanyName(companyName);

        return addNameCardVO;
    }
}




