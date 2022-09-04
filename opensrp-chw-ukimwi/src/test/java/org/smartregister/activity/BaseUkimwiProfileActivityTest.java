package org.smartregister.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.ukimwi.activity.BaseUkimwiProfileActivity;
import org.smartregister.chw.ukimwi.contract.UkimwiProfileContract;
import org.smartregister.domain.AlertStatus;
import org.smartregister.ukimwi.R;

import static org.mockito.Mockito.validateMockitoUsage;

public class BaseUkimwiProfileActivityTest {
    @Mock
    public BaseUkimwiProfileActivity baseUkimwiProfileActivity;

    @Mock
    public UkimwiProfileContract.Presenter profilePresenter;

    @Mock
    public View view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseUkimwiProfileActivity);
    }

    @Test
    public void setOverDueColor() {
        baseUkimwiProfileActivity.setOverDueColor();
        Mockito.verify(view, Mockito.never()).setBackgroundColor(Color.RED);
    }

    @Test
    public void formatTime() {
        BaseUkimwiProfileActivity activity = new BaseUkimwiProfileActivity();
        try {
            Assert.assertEquals("25 Oct 2019", Whitebox.invokeMethod(activity, "formatTime", "25-10-2019"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkHideView() {
        baseUkimwiProfileActivity.hideView();
        Mockito.verify(view, Mockito.never()).setVisibility(View.GONE);
    }

    @Test
    public void checkProgressBar() {
        baseUkimwiProfileActivity.showProgressBar(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void medicalHistoryRefresh() {
        baseUkimwiProfileActivity.refreshMedicalHistory(true);
        Mockito.verify(view, Mockito.never()).setVisibility(View.VISIBLE);
    }

    @Test
    public void onClickBackPressed() {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.title_layout);
        Mockito.doNothing().when(baseUkimwiProfileActivity).onBackPressed();
        baseUkimwiProfileActivity.onClick(view);
        Mockito.verify(baseUkimwiProfileActivity).onBackPressed();
    }

    @Test
    public void onClickOpenMedicalHistory() {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlLastVisit);
        Mockito.doNothing().when(baseUkimwiProfileActivity).openMedicalHistory();
        baseUkimwiProfileActivity.onClick(view);
        Mockito.verify(baseUkimwiProfileActivity).openMedicalHistory();
    }

    @Test
    public void onClickOpenUpcomingServices() {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlUpcomingServices);
        Mockito.doNothing().when(baseUkimwiProfileActivity).openUpcomingService();
        baseUkimwiProfileActivity.onClick(view);
        Mockito.verify(baseUkimwiProfileActivity).openUpcomingService();
    }

    @Test
    public void onClickOpenFamlilyServicesDue() {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        Mockito.when(view.getId()).thenReturn(R.id.rlFamilyServicesDue);
        Mockito.doNothing().when(baseUkimwiProfileActivity).openFamilyDueServices();
        baseUkimwiProfileActivity.onClick(view);
        Mockito.verify(baseUkimwiProfileActivity).openFamilyDueServices();
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusComplete() throws Exception {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseUkimwiProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseUkimwiProfileActivity).showProgressBar(false);
        baseUkimwiProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseUkimwiProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseUkimwiProfileActivity).invoke("setFamilyStatus", "Family has nothing due");
    }

    @Test(expected = Exception.class)
    public void refreshFamilyStatusNormal() throws Exception {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        TextView textView = view.findViewById(R.id.textview_family_has);
        Whitebox.setInternalState(baseUkimwiProfileActivity, "tvFamilyStatus", textView);
        Mockito.doNothing().when(baseUkimwiProfileActivity).showProgressBar(false);
        baseUkimwiProfileActivity.refreshFamilyStatus(AlertStatus.complete);
        Mockito.verify(baseUkimwiProfileActivity).showProgressBar(false);
        PowerMockito.verifyPrivate(baseUkimwiProfileActivity).invoke("setFamilyStatus", "Family has services due");
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        baseUkimwiProfileActivity = Mockito.spy(new BaseUkimwiProfileActivity());
        Whitebox.invokeMethod(baseUkimwiProfileActivity, "onActivityResult", 2244, -1, null);
        Mockito.verify(profilePresenter).saveForm(null);
    }

}
