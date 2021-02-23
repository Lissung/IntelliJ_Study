package view.viewService;

import vo.NameCardVO;

import java.util.List;

public interface ManageViewService {

    public void manageMenuSelectingView();
    public void searchingCardView();
    public List<NameCardVO> searchByCompanynameView();
    public NameCardVO searchByWorkerNameView();
    public NameCardVO searchByPhoneNumberView();
    public void editingCardView(NameCardVO resultNameCardVO);

    public void listingUpCardView();
    public void addingCardView();

}
