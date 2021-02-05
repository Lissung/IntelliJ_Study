import view.viewImpl.MainViewImpl;
import view.viewService.MainViewService;

public class NameCardManager {

    public static void main(String[] args) {

        MainViewService mainViewService = new MainViewImpl();
        mainViewService.mainView();
        System.exit(0);

    }
}
