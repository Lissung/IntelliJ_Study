package view.viewImpl;

import constant.Constant;
import model.modelService.ListingUpService;
import model.modelmpl.ListingUpImpl;
import view.viewService.ListingUpViewService;
import vo.NameCardVO;

import java.util.List;
import java.util.Scanner;

public class ListingUpViewImpl implements ListingUpViewService {

    ListingUpService listingUpService = ListingUpImpl.getInstance();
    Scanner scanner = new Scanner(System.in);

    여기해야됨
    public void listingUpCardView() {
        boolean comingLisitngUpCardView = true;

        while (true) {
            System.out.println(" << Listing Up name card by >> ");
            System.out.println("");
            System.out.println("");
            System.out.println("1. Grouping by company name");
            System.out.println("");
            System.out.println("2. Ascending by worker name");
            System.out.println("");
            System.out.println("3. Descending by worker name");
            System.out.println("");
            System.out.println(">>");
            System.out.println("4. Exit Listing up card view");
            System.out.println("");
            System.out.println(">>");

            int listingUpMenu = scanner.nextInt();

            switch (listingUpMenu) {
                case Constant.By_Grouping:
                    this.listingUp_GroupingView();
                    break;
                case Constant.By_Ascending:
                    this.listingUp_AscendingView();
                    break;
                case Constant.By_Descending:
                    this.listingUp_DescendingView();
                    break;
                case Constant.Exit_ListUpVIew:
                    comingLisitngUpCardView = false;
                    break;
            }
        }
    }

    @Override
    public void listingUp_GroupingView() {
        System.out.println(" << Input Company name for grouping >> ");
        System.out.println("");
        System.out.println("");
        System.out.println(">> ");
        String companyNameForGrouping = scanner.nextLine();

        List<NameCardVO> listByGrouping = listingUpService.groupingByCompany(companyNameForGrouping);
        System.out.println(listByGrouping.toString());
    }

    @Override
    public void listingUp_AscendingView() {
        System.out.println(" << Result >> ");
        System.out.println("");
        System.out.println("");

        List<NameCardVO> listByAscending = listingUpService.ascendingByName();
        System.out.println(listByAscending.toString());
    }

    @Override
    public void listingUp_DescendingView() {
        System.out.println(" << Result >> ");
        System.out.println("");
        System.out.println("");

        List<NameCardVO> listByDedscending = listingUpService.descendingByName();
        System.out.println(listByDedscending.toString());
    }


}
