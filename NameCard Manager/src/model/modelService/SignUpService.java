package model.modelService;

public interface SignUpService {

    public int checkSignUpID(String signUpID);
    public void setSignUpID(String signUpID, String signUpPWD) throws Exception;

}
