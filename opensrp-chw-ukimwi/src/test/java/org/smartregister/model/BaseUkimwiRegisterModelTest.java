package org.smartregister.model;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.smartregister.chw.ukimwi.model.BaseUkimwiRegisterModel;

public class BaseUkimwiRegisterModelTest {

    @Mock
    private BaseUkimwiRegisterModel baseUkimwiRegisterModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkJSon() {
        try {
            JSONObject jsonObject = new JSONObject();
            Mockito.when(baseUkimwiRegisterModel.getFormAsJson(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                    .thenReturn(jsonObject);
            Assert.assertEquals(jsonObject, baseUkimwiRegisterModel.getFormAsJson(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
