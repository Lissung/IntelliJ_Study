package model.modelService;

import vo.NameCardVO;

import java.util.List;

public interface ManageService {

    //Searching menu
    public void searchingCard();
    public void listingUpCard();
    public void addingCard();

    //Searching
    public int searchByCompanyName(String companyName);
    public int searchByWorkerName(String workerName);
    public int searchByPhoneNumber(int phoneNumber);
    public NameCardVO selectSubjectToEdit(NameCardVO resultNameCardVO, int subjectToEdit, Long detailsToEdit);


    //Searching Conditions
    public List<NameCardVO> showingResult_Company(String input);
    public NameCardVO showingResult_Worker(String input);
    public NameCardVO showingResult_PhoneNum(int input);

    // adding
    public NameCardVO addingNewNameCard( String companyName, String workerName, String position,
                                   String locationOfCompany, Integer phoneNumber);

}
