package model.modelmpl;

import model.modelService.LogInService;

public class LogInImpl implements LogInService {

    private static LogInImpl instance;

    public static LogInImpl getInstance(){

        if(instance==null){
            instance = new LogInImpl();
        }
        return instance;

    }

    @Override
    public int checkUserID(String logInID, String logInPWD) {
        int isLogInID = 0;
        return isLogInID;
    }
}
