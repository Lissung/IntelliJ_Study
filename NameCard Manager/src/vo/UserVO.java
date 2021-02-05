package vo;

public class UserVO {

    String userID;
    String userPWD;

    @Override
    public String toString() {
        return "UserVO{" +
                "userID='" + userID + '\'' +
                ", userPWD='" + userPWD + '\'' +
                '}';
    }

    public void UserVO(){}

    public void UserVO(String userID, String userPWD){
        userID = this.userID;
        userPWD = this.userPWD;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPWD() {
        return userPWD;
    }

    public void setUserPWD(String userPWD) {
        this.userPWD = userPWD;
    }
}
