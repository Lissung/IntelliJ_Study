package view.viewService;

import vo.NameCardVO;

public interface ManageViewService {

    public void manageMenuSelectingView();
    public void searchingCardView();
    public NameCardVO searchByCompanynameView();
    public NameCardVO searchByWorkerNameView();
    public NameCardVO searchByPhoneNumberView();
    public void editingCardView(NameCardVO resultNameCardVO);

    public void listingUpCardView();
    public void addingCardView();

}
