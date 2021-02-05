package model.modelService;

import model.modelmpl.LogInImpl;

public interface LogInService {

    public int checkUserID(String logInID, String logInPWD);


}
