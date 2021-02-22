package vo;

public class NameCardVO {

    String companyName;
    String workerName;
    String position;
    String locationOfCompany;
    Integer phoneNumber;

    @Override
    public String toString() {
        return "NameCardVO{" +
                "companyName='" + companyName + '\'' +
                ", workerName='" + workerName + '\'' +
                ", position='" + position + '\'' +
                ", locationOfCompany='" + locationOfCompany + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    public NameCardVO(){}

    public NameCardVO(String companyName, String workerName, String position, String locationOfCompany, int phoneNumber){
        this.companyName       = companyName;
        this.workerName        = workerName;
        this.position          = position;
        this.locationOfCompany = locationOfCompany;
        this.phoneNumber       = phoneNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocationOfCompany() {
        return locationOfCompany;
    }

    public void setLocationOfCompany(String locationOfCompany) {
        this.locationOfCompany = locationOfCompany;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmpty() {
        return true;
    }
}
