package org.smartregister.chw.ukimwi.model;

import org.json.JSONObject;
import org.smartregister.chw.ukimwi.contract.UkimwiRegisterContract;
import org.smartregister.chw.ukimwi.util.UkimwiJsonFormUtils;

public class BaseUkimwiRegisterModel implements UkimwiRegisterContract.Model {

    @Override
    public JSONObject getFormAsJson(String formName, String entityId, String currentLocationId) throws Exception {
        JSONObject jsonObject = UkimwiJsonFormUtils.getFormAsJson(formName);
        UkimwiJsonFormUtils.getRegistrationForm(jsonObject, entityId, currentLocationId);

        return jsonObject;
    }

}
