package model.modelService;

import vo.NameCardVO;

import java.util.List;

public interface ListingUpService {

    public List<NameCardVO> groupingByCompany(String companyNameForGrouping);
    public List<NameCardVO> ascendingByName();
    public List<NameCardVO> descendingByName();

}
