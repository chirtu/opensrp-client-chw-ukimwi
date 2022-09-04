package org.smartregister.activity;

import android.content.Intent;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.reflect.Whitebox;
import org.smartregister.chw.ukimwi.activity.BaseUkimwiRegisterActivity;

public class BaseUkimwiRegisterActivityTest {
    @Mock
    public Intent data;
    @Mock
    private BaseUkimwiRegisterActivity baseUkimwiRegisterActivity = new BaseUkimwiRegisterActivity();

    @Test
    public void assertNotNull() {
        Assert.assertNotNull(baseUkimwiRegisterActivity);
    }

    @Test
    public void testFormConfig() {
        Assert.assertNull(baseUkimwiRegisterActivity.getFormConfig());
    }

    @Test
    public void checkIdentifier() {
        Assert.assertNotNull(baseUkimwiRegisterActivity.getViewIdentifiers());
    }

    @Test(expected = Exception.class)
    public void onActivityResult() throws Exception {
        Whitebox.invokeMethod(baseUkimwiRegisterActivity, "onActivityResult", 2244, -1, data);
        Mockito.verify(baseUkimwiRegisterActivity.presenter()).saveForm(null);
    }

}
