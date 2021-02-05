package view.viewImpl;

import constant.Constant;
import view.viewService.LogInViewService;
import view.viewService.MainViewService;
import view.viewService.SignUpIViewService;

import java.util.Scanner;

public class MainViewImpl implements MainViewService {

    LogInViewService logInViewService = new LogInViewImpl();
    SignUpIViewService signUpIViewService = new SignUpViewImpl();
    Scanner scanner = new Scanner(System.in);

    public void mainView(){

        boolean main = true;
        while (main) {
            System.out.println("     << Select Menu >>     ");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Log In");
            System.out.println("");
            System.out.println("2. Sign In");
            System.out.println("");
            System.out.println("3. Exit");
            System.out.println("");
            System.out.println(">>");

            int mainSelecting = scanner.nextInt();

            switch (mainSelecting) {
                case Constant.LogIN:
                    logInViewService.logInView();
                case Constant.SingIn:
                    signUpIViewService.signUpView();
                case Constant.Exit:
                    main = false;
                    break;
            }
        }
    }
}
