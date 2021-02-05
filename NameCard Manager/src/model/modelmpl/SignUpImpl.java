package model.modelmpl;

import model.modelService.SignUpService;
import vo.UserVO;

public class SignUpImpl implements SignUpService {

    private static SignUpImpl instance;

    public static SignUpImpl getInstance(){

        if(instance==null){
            instance = new SignUpImpl();
        }
        return instance;

    }

    @Override
    public int checkSignUpID(String SignUpID) {
        int isIdExist_ = 0;

        return isIdExist_;
    }

    @Override
    public void setSignUpID(String signUpID, String signUpPWD) {
        UserVO userVO = new UserVO();
        userVO.setUserID(signUpID);
        userVO.setUserPWD(signUpPWD);
    }


}
