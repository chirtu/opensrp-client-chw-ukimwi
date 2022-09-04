package org.smartregister.fragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.ukimwi.activity.BaseUkimwiProfileActivity;
import org.smartregister.chw.ukimwi.fragment.BaseUkimwiRegisterFragment;
import org.smartregister.commonregistry.CommonPersonObjectClient;

import static org.mockito.Mockito.times;

public class BaseUkimwiRegisterFragmentTest {
    @Mock
    public BaseUkimwiRegisterFragment baseUkimwiRegisterFragment;

    @Mock
    public CommonPersonObjectClient client;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void openProfile() throws Exception {
        Whitebox.invokeMethod(baseUkimwiRegisterFragment, "openProfile", client);
        PowerMockito.mockStatic(BaseUkimwiProfileActivity.class);
        BaseUkimwiProfileActivity.startProfileActivity(null, null);
        PowerMockito.verifyStatic(times(1));

    }
}
