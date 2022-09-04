package org.smartregister.presenter;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.smartregister.chw.ukimwi.contract.UkimwiProfileContract;
import org.smartregister.chw.ukimwi.domain.MemberObject;
import org.smartregister.chw.ukimwi.presenter.BaseUkimwiProfilePresenter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseUkimwiProfilePresenterTest {

    @Mock
    private UkimwiProfileContract.View view = Mockito.mock(UkimwiProfileContract.View.class);

    @Mock
    private UkimwiProfileContract.Interactor interactor = Mockito.mock(UkimwiProfileContract.Interactor.class);

    @Mock
    private MemberObject memberObject = new MemberObject();

    private BaseUkimwiProfilePresenter profilePresenter = new BaseUkimwiProfilePresenter(view, interactor, memberObject);


    @Test
    public void fillProfileDataCallsSetProfileViewWithDataWhenPassedMemberObject() {
        profilePresenter.fillProfileData(memberObject);
        verify(view).setProfileViewWithData();
    }

    @Test
    public void fillProfileDataDoesntCallsSetProfileViewWithDataIfMemberObjectEmpty() {
        profilePresenter.fillProfileData(null);
        verify(view, never()).setProfileViewWithData();
    }

    @Test
    public void ukimwiTestDatePeriodIsLessThanSeven() {
        profilePresenter.recordUkimwiButton("");
        verify(view).hideView();
    }

    @Test
    public void ukimwiTestDatePeriodGreaterThanTen() {
        profilePresenter.recordUkimwiButton("OVERDUE");
        verify(view).setOverDueColor();
    }

    @Test
    public void ukimwiTestDatePeriodIsMoreThanFourteen() {
        profilePresenter.recordUkimwiButton("EXPIRED");
        verify(view).hideView();
    }

    @Test
    public void refreshProfileBottom() {
        profilePresenter.refreshProfileBottom();
        verify(interactor).refreshProfileInfo(memberObject, profilePresenter.getView());
    }

    @Test
    public void saveForm() {
        profilePresenter.saveForm(null);
        verify(interactor).saveRegistration(null, view);
    }
}
