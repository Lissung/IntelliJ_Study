package model.modelmpl;

import model.modelService.ManageService;
import vo.NameCardVO;
import vo.UserVO;

import java.util.List;

public class ManageImpl implements ManageService {

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
