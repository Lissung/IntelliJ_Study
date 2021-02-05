package view.viewImpl;

import constant.Constant;
import model.modelService.LogInService;
import model.modelmpl.LogInImpl;
import view.viewService.LogInViewService;
import view.viewService.ManageViewService;

import java.util.Scanner;

public class LogInViewImpl implements LogInViewService {

    LogInService logInService = LogInImpl.getInstance();
    ManageViewService manageViewService = new ManageView();
    Scanner scanner = new Scanner(System.in);

    public void logInView() {

        boolean logIn = true;

        while (logIn) {
            System.out.println("<<    Log In   >>");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Put your ID");
            System.out.println("");
            System.out.println(">>");
            String logInID = scanner.nextLine();
            System.out.println("");
            System.out.println("2. Put your PWD");
            System.out.println("");
            System.out.println(">>");
            String logInPWD = scanner.nextLine();
            int isLogIn = logInService.checkUserID(logInID, logInPWD);

            switch (isLogIn){
                case Constant.logIN_Success:
                    System.out.println(" Log In Success!! ");
                    manageViewService.manageMenuSelectingView();
                case Constant.id_Not_Exist:
                    System.out.println("ID is not Exist. Please sign up first");
                    logIn = false;
                    break;
                case Constant.pwd_Is_Not_Correct:
                    System.out.println("Incorrect PWD. Please try again");
                    break;
            }

        }
    }


}
