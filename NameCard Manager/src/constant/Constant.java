package constant;

public class Constant {

    //Main
    public final static int LogIN  = 1;
    public final static int SingIn = 2;
    public final static int Exit   = 3;

    //SignUp
    public final static int ID_Unavailable = 1;
    public final static int ID_Available   = 2;

    //checkID
    public final static int logIN_Success      = 1;
    public final static int id_Not_Exist       = 2;
    public final static int pwd_Is_Not_Correct = 3;

    //Manage Menu selecting
    public final static int Searching_Card = 1;
    public final static int ListingUp_Card = 2;
    public final static int Adding_Card    = 3;
    public final static int Exit_ManageView= 4;

    //Searching Conditions
    public final static int By_CompanyName = 1;
    public final static int By_WorkerName  = 2;
    public final static int By_PhoneNumber = 3;
    public final static int EXIT_SEARCHING = 4;

    // Searching
    public final static int is_Not_CompanyName = 1;
    public final static int is_CompanyName     = 2;

    // Edit
    public final static int is_Editing         = 1;
    public final static int is_Not_Editing     = 2;
    public final static int Edit_companyName         = 1;
    public final static int Edit_workerName          = 2;
    public final static int Edit_position            = 3;
    public final static int Edit_locationOfCompany   = 4;
    public final static int Edit_phoneNumber         = 5;


    public final static int is_Not_WorkerName = 1;
    public final static int is_WorkerName     = 2;

    public final static int is_Not_PhoneNumber = 1;
    public final static int is_PhoneNumber     = 2;

    // Listing Up Condition
    public final static int By_Grouping     = 1;
    public final static int By_Ascending    = 2;
    public final static int By_Descending   = 3;
    public final static int Exit_ListUpVIew = 4;

    // AddingCard View
    public final static int Do_Add          = 1;
    public final static int Exit_AddingView = 2;

}
