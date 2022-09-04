package org.smartregister.presenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.ukimwi.contract.UkimwiRegisterFragmentContract;
import org.smartregister.chw.ukimwi.presenter.BaseUkimwiRegisterFragmentPresenter;
import org.smartregister.chw.ukimwi.util.Constants;
import org.smartregister.chw.ukimwi.util.DBConstants;
import org.smartregister.configurableviews.model.View;

import java.util.Set;
import java.util.TreeSet;

public class BaseUkimwiRegisterFragmentPresenterTest {
    @Mock
    protected UkimwiRegisterFragmentContract.View view;

    @Mock
    protected UkimwiRegisterFragmentContract.Model model;

    private BaseUkimwiRegisterFragmentPresenter baseUkimwiRegisterFragmentPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        baseUkimwiRegisterFragmentPresenter = new BaseUkimwiRegisterFragmentPresenter(view, model, "");
    }

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseUkimwiRegisterFragmentPresenter);
    }

    @Test
    public void getMainCondition() {
        Assert.assertEquals("", baseUkimwiRegisterFragmentPresenter.getMainCondition());
    }

    @Test
    public void getDueFilterCondition() {
        Assert.assertEquals(" (cast( julianday(STRFTIME('%Y-%m-%d', datetime('now'))) -  julianday(IFNULL(SUBSTR(ukimwi_test_date,7,4)|| '-' || SUBSTR(ukimwi_test_date,4,2) || '-' || SUBSTR(ukimwi_test_date,1,2),'')) as integer) between 7 and 14) ", baseUkimwiRegisterFragmentPresenter.getDueFilterCondition());
    }

    @Test
    public void getDefaultSortQuery() {
        Assert.assertEquals(Constants.TABLES.UKIMWI_CONFIRMATION + "." + DBConstants.KEY.LAST_INTERACTED_WITH + " DESC ", baseUkimwiRegisterFragmentPresenter.getDefaultSortQuery());
    }

    @Test
    public void getMainTable() {
        Assert.assertEquals(Constants.TABLES.UKIMWI_CONFIRMATION, baseUkimwiRegisterFragmentPresenter.getMainTable());
    }

    @Test
    public void initializeQueries() {
        Set<View> visibleColumns = new TreeSet<>();
        baseUkimwiRegisterFragmentPresenter.initializeQueries(null);
        Mockito.doNothing().when(view).initializeQueryParams("ec_ukimwi_confirmation", null, null);
        Mockito.verify(view).initializeQueryParams("ec_ukimwi_confirmation", null, null);
        Mockito.verify(view).initializeAdapter(visibleColumns);
        Mockito.verify(view).countExecute();
        Mockito.verify(view).filterandSortInInitializeQueries();
    }

}