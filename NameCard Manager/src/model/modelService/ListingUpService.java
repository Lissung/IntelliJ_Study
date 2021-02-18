package model.modelService;

import vo.NameCardVO;

import java.util.List;

public interface ListingUpService {

    public List<NameCardVO> groupingByCompany(String companyNameForGrouping);
    public List<List<NameCardVO>> ascendingByName();
    public List<List<NameCardVO>> descendingByName();

}
