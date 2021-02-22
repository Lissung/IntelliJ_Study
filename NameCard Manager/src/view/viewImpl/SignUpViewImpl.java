package view.viewImpl;

import constant.Constant;
import model.modelService.SignUpService;
import model.modelmpl.SignUpImpl;
import view.viewService.SignUpIViewService;

import java.util.Scanner;

public class SignUpViewImpl implements SignUpIViewService {

    SignUpService signUpService = SignUpImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void signUpView() {
        String signUpID = null;


            System.out.println("    <<  Make New ID / PWD  >>");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Input the ID you want");
            System.out.println("");
            System.out.println(">>");
            signUpID = scanner.nextLine();
            int idCheck = signUpService.checkSignUpID(signUpID);

            switch (idCheck) {
                case Constant.ID_Unavailable:
                    System.out.println(" ** The ID is used already. Input another ID  **");
                    System.out.println("");
                    System.out.println("");
                    break;
                case Constant.ID_Available:
                    this.inputSignUpPWD(signUpID);
                    break;
            }
        }


     private void inputSignUpPWD(String signUpID){
        System.out.println("");
        System.out.println("2. Input the PWD you want");
        System.out.println("");
        System.out.println(">>");
        System.out.println("");
        String signUpPWD = scanner.nextLine();
        try {
            signUpService.setSignUpID(signUpID, signUpPWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" **  Success Sign-up **  ");
        System.out.println("");
        System.out.println("");
    }
}
