package view.viewImpl;

import constant.Constant;
import model.modelService.ManageService;
import model.modelmpl.ManageImpl;
import view.viewService.ListingUpViewService;
import view.viewService.ManageViewService;
import vo.NameCardVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageView implements ManageViewService {

    ManageService manageService = ManageImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void manageMenuSelectingView() {
        boolean comingManageView = true;

        while (comingManageView) {
            System.out.println("    <<   Select Menu   >>    ");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Searching a Name card");
            System.out.println("");
            System.out.println("2. Listing up Name cards you have");
            System.out.println("");
            System.out.println("3. Adding a new Name card");
            System.out.println("");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.println(">>");
            System.out.println("");

            int manageMenu = scanner.nextInt();

            switch (manageMenu) {
                case Constant.Searching_Card:
                    this.searchingCardView();
                    break;
                case Constant.ListingUp_Card:
                    this.listingUpCardView();
                    break;
                case Constant.Adding_Card:
                    this.addingCardView();
                    break;
                case Constant.Exit_ManageView:
                    ;
                    comingManageView = false;
                    break;
            }
        }
    }

    // searching
    public void searchingCardView() {
        boolean comingSearchinCardView = true;

        while (comingSearchinCardView) {
            System.out.println(" << Search a name card by >> ");
            System.out.println("");
            System.out.println("1. by Company Name");
            System.out.println("");
            System.out.println("2. by Worker Name");
            System.out.println("");
            System.out.println("3. by Phone Number");
            System.out.println("");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.println(">>");

            NameCardVO resultNameCardVO = new NameCardVO();

            int searchingCondition = scanner.nextInt();
            scanner.nextLine();

            switch (searchingCondition) {
                case Constant.By_CompanyName:
                    this.searchByCompanynameView();
                    break;
                case Constant.By_WorkerName:
                    resultNameCardVO = this.searchByWorkerNameView();
                    break;
                case Constant.By_PhoneNumber:
                    resultNameCardVO = this.searchByPhoneNumberView();
                    break;
                case Constant.EXIT_SEARCHING:
                    comingSearchinCardView = false;
                    break;
            }

            if (comingSearchinCardView == false) {
                break;
            } else if (resultNameCardVO != null && resultNameCardVO.getWorkerName()==null) {
                break;
            } else if (searchingCondition == Constant.By_CompanyName) {
                break;
            } else {
                this.editingCardView(resultNameCardVO);
                break;
            }
        }
    }

    // 애는 키값이 아니라 안될거 같음 → 찾아서 showing만 하고 edit 안하면 될듯
    public List<NameCardVO> searchByCompanynameView() {

        List<NameCardVO> searchingResult_Compnany = new ArrayList<>();


        System.out.println(" << Input Company Name >> ");
        System.out.println("");
        System.out.println("");
        System.out.println(">> ");
        System.out.println("");
        String companyName = scanner.nextLine();

        int isCompanyName = manageService.searchByCompanyName(companyName);

        switch (isCompanyName) {
            case Constant.is_Not_CompanyName:
                System.out.println(" ** Please check the Name of company again ** ");
                System.out.println("");
                break;
            case Constant.is_CompanyName:
                searchingResult_Compnany = manageService.showingResult_Company(companyName);
                System.out.println(" << Contents >> ");
                System.out.println("");
                System.out.println(searchingResult_Compnany.toString());
                System.out.println("");
                break;
        }
        return searchingResult_Compnany;
    }

    public NameCardVO searchByWorkerNameView() {
        boolean comingSearchByWorkerNameView = true;
        NameCardVO searchingResult_Worker = new NameCardVO();


        System.out.println(" << Input Worker Name >> ");
        System.out.println("");
        System.out.println("");
        System.out.println(">> ");
        System.out.println("");
        String workerName = scanner.nextLine();

        int isWorkerName = manageService.searchByWorkerName(workerName);

        switch (isWorkerName) {
            case Constant.is_Not_WorkerName:
                System.out.println("Please check the Name of worker again");
                System.out.println("");
                break;
            case Constant.is_WorkerName:
                searchingResult_Worker = manageService.showingResult_Worker(workerName);
                System.out.println(" << Contents >> ");
                System.out.println("");
                System.out.println(searchingResult_Worker.toString());
                break;
        }
        return searchingResult_Worker;
    }

    public NameCardVO searchByPhoneNumberView() {

        NameCardVO searchingResult_PhoneNumber = new NameCardVO();
            System.out.println(" << Input Phone Number >> ");
            System.out.println("");
            System.out.println("");
            System.out.println(">> ");
            System.out.println("");
            int phoneNumber = scanner.nextInt();
            scanner.nextLine();

            int isPhoneNumber = manageService.searchByPhoneNumber(phoneNumber);

            switch (isPhoneNumber) {
                case Constant.is_Not_PhoneNumber:
                    System.out.println("Please check the Name of Phone Number again");
                    System.out.println("");
                    break;
                case Constant.is_PhoneNumber:
                    searchingResult_PhoneNumber = manageService.showingResult_PhoneNum(phoneNumber);
                    System.out.println(" << Contents >> ");
                    System.out.println("");
                    System.out.println(searchingResult_PhoneNumber.toString());
                    break;
            }
        return searchingResult_PhoneNumber;
    }

    @Override
    public void editingCardView(NameCardVO resultNameCardVO) {

        System.out.println(" << Edit contents on Card? >> ");
        System.out.println("");
        System.out.println("1. Yes ");
        System.out.println("");
        System.out.println("2. No");
        System.out.println("");
        System.out.println(">> ");

        int isEditing = scanner.nextInt();
        switch (isEditing) {
            case Constant.is_Editing:
                System.out.println("                << Input a subject to change the content >> ");
                System.out.println("");
                System.out.println("(1. companyName/ 2. workerName / 3. position / 4. locationOfCompany / 5. phoneNumber");
                System.out.println("");
                System.out.println("");
                System.out.println(">> ");
                int subjectToEdit = scanner.nextInt();
                System.out.println("");
                System.out.println("");
                System.out.println(" << Input details for changing the content >> ");
                System.out.println("");
                System.out.println("");
                System.out.println(">> ");
                Long detailsToEdit = scanner.nextLong();


                NameCardVO nameCardVO_editted = manageService.selectSubjectToEdit(resultNameCardVO, subjectToEdit, detailsToEdit);
                System.out.println(nameCardVO_editted.toString());
                break;

            case Constant.is_Not_Editing:
                break;
        }
    }


    //listing
    public void listingUpCardView() {
        ListingUpViewService listingUpViewService = new ListingUpViewImpl();
        listingUpViewService.listingUpCardView();
    }


    //adding
    public void addingCardView() {

            System.out.println(" << Do add new card?? >> ");
            System.out.println("");
            System.out.println("");
            System.out.println(" Yes, press 1 ");
            System.out.println(" No,  press 2 ");
            System.out.println("");
            System.out.println(">> ");
            int continueAddingCardView = scanner.nextInt();
            scanner.nextLine();


            switch (continueAddingCardView) {
                case Constant.Do_Add:
                    System.out.println(" << Input contents for adding >> ");
                    System.out.println("");
                    System.out.println("");
                    System.out.println(" What is 'Company Name' ?? ");
                    System.out.println("");
                    System.out.println(">> ");
                    String addCompanyName = scanner.nextLine();
                    System.out.println("");
                    System.out.println(" What is 'Worker Name' ?? ");
                    System.out.println("");
                    System.out.println(">> ");
                    String addWokrerName = scanner.nextLine();
                    System.out.println("");
                    System.out.println(" What is 'Worker's position' ?? ");
                    System.out.println("");
                    System.out.println(">> ");
                    String addPosition = scanner.nextLine();
                    System.out.println("");
                    System.out.println(" What is 'Location fo Company' ?? ");
                    System.out.println("");
                    System.out.println(">>");
                    String addLocation = scanner.nextLine();
                    System.out.println("");
                    System.out.println(" What is 'Phone Number' ??' ");
                    System.out.println("");
                    System.out.println(">>");
                    int addPhoneNum = scanner.nextInt();
                    System.out.println("");

                    NameCardVO add_NameCardVO = manageService.addingNewNameCard(addCompanyName, addWokrerName,
                            addLocation, addPosition, addPhoneNum);
                    System.out.println(add_NameCardVO.toString());
                    System.out.println("");
                    System.out.println(" ** Done it !! **");
                    System.out.println("");
                    break;

                case Constant.Exit_AddingView:
                    break;

        }
    }
}
