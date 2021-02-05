package model.modelmpl;

import model.modelService.ListingUpService;
import vo.NameCardVO;

import java.util.List;

public class ListingUpImpl implements ListingUpService {

    private static ListingUpImpl instance;

    public static ListingUpImpl getInstance(){

        if(instance==null){
            instance = new ListingUpImpl();
        }
        return instance;

    }

    @Override
    public List<NameCardVO> groupingByCompany(String companyNameForGrouping) {
        List<NameCardVO> groupingList = null;

        return groupingList;
    }

    @Override
    public List<NameCardVO> ascendingByName() {
        List<NameCardVO> ascendingList = null;

        return null;
    }

    @Override
    public List<NameCardVO> descendingByName() {
        List<NameCardVO> descendingList = null;

        return null;
    }
}
