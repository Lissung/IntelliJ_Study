package view.viewImpl;

import constant.Constant;
import model.modelService.ManageService;
import model.modelmpl.ManageImpl;
import view.viewService.ListingUpViewService;
import view.viewService.ManageViewService;
import vo.NameCardVO;
import vo.UserVO;

import java.util.List;
import java.util.Scanner;

public class ManageView implements ManageViewService {

    ManageService manageService = ManageImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void manageMenuSelectingView() {

        System.out.println("    <<   Select Menu   >>    ");
        System.out.println("");
        System.out.println("");
        System.out.println("1. Searching a Name card");
        System.out.println("");
        System.out.println("2. Listing up Name cards you have");
        System.out.println("");
        System.out.println("3. Adding a Name card contents");
        System.out.println("");
        System.out.println(">>");
        System.out.println("");

        int manageMenu = scanner.nextInt();

        switch (manageMenu) {
            case Constant.Searching_Card:
                this.searchingCardView();
            case Constant.ListingUp_Card:
                this.listingUpCardView();
            case Constant.Adding_Card:
                this.addingCardView();
        }
    }

    public void searchingCardView() {

        System.out.println(" << Search a name card by >> ");
        System.out.println("");
        System.out.println("1. by Company Name");
        System.out.println("");
        System.out.println("2. by Worker Name");
        System.out.println("");
        System.out.println("3. by Phone Number");
        System.out.println("");
        System.out.println(">>");

        int searchingCondition = scanner.nextInt();

        switch (searchingCondition) {
            case Constant.By_CompanyName:
                this.searchByCompanynameView();
                break;
            case Constant.By_WorkerName:
                this.searchByWorkerNameView();
                break;
            case Constant.By_PhoneNumber:
                this.searchByPhoneNumberView();
                break;
        }
        this.editingCardView();
    }

    public void searchByCompanynameView(){
        System.out.println(" << Input Company Name >> ");
        System.out.println("");
        System.out.println("");
        System.out.println(">> ");
        System.out.println("");
        String companyName = scanner.nextLine();

        int isCompanyName = manageService.searchByCompanyName(companyName);

        switch (isCompanyName) {
            case Constant.is_Not_CompanyName:
                System.out.println("Please check the Name of company again");
            case Constant.is_CompanyName:
                NameCardVO searchingResult_Compnany = manageService.showingResult_Company(companyName);
                System.out.println(" << Contents >> ");
                System.out.println("");
                System.out.println("");
                System.out.println(searchingResult_Compnany.toString());
        }
    }

    public void searchByWorkerNameView(){
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
            case Constant.is_WorkerName:
                NameCardVO searchingResult_Worker = manageService.showingResult_Worker(workerName);
                System.out.println(" << Contents >> ");
                System.out.println("");
                System.out.println("");
                System.out.println(searchingResult_Worker.toString());
        }
    }

    public void searchByPhoneNumberView(){
        System.out.println(" << Input Phone Number >> ");
        System.out.println("");
        System.out.println("");
        System.out.println(">> ");
        System.out.println("");
        String phoneNumber = scanner.nextLine();

        int isPhoneNumber = manageService.searchByPhoneNumber(phoneNumber);

        switch (isPhoneNumber) {
            case Constant.is_Not_PhoneNumber:
                System.out.println("Please check the Name of worker again");
            case Constant.is_PhoneNumber:
                NameCardVO searchingResult_PhoneNumber = manageService.showingResult_Worker(phoneNumber);
                System.out.println(" << Contents >> ");
                System.out.println("");
                System.out.println("");
                System.out.println(searchingResult_PhoneNumber.toString());
        }
    }

    @Override
    public void editingCardView() {
        System.out.println(" << Edit contents on Card? >> ");
        System.out.println("");
        System.out.println("1. Yes ");
        System.out.println("");
        System.out.println("2. No");
        System.out.println("");
        System.out.println(">> ");

        int isEditing = scanner.nextInt();
        if(isEditing==Constant.is_Editing){
            System.out.println("                << Input a subject to change the content >> ");
            System.out.println("");
            System.out.println("(companyName/ workerName / position / locationOfCompany / phoneNumber");
            System.out.println("");
            System.out.println("");
            System.out.println(">> ");

            String subjectEdit = scanner.nextLine();
            NameCardVO nameCardVO_editted = manageService.editingContent(subjectEdit);
            System.out.println(nameCardVO_editted.toString());
        }

    }

    public void listingUpCardView() {
        ListingUpViewService listingUpViewService = new ListingUpViewImpl();
        listingUpViewService.listingUpCardView();
    }

    public void addingCardView() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

    }

}
