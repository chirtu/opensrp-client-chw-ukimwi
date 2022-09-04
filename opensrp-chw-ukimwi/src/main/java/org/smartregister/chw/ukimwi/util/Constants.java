package org.smartregister.chw.ukimwi.util;

public interface Constants {

    int REQUEST_CODE_GET_JSON = 2244;
    String ENCOUNTER_TYPE = "encounter_type";
    String STEP_ONE = "step1";
    String STEP_TWO = "step2";

    interface JSON_FORM_EXTRA {
        String JSON = "json";
        String ENCOUNTER_TYPE = "encounter_type";
    }

    interface EVENT_TYPE {
        String UKIMWI_CONFIRMATION = "Ukimwi Confirmation";
        String UKIMWI_FOLLOW_UP_VISIT = "Ukimwi Follow-up Visit";
    }

    interface FORMS {
        String UKIMWI_REGISTRATION = "ukimwi_confirmation";
        String UKIMWI_FOLLOW_UP_VISIT = "ukimwi_followup_visit";
    }

    interface TABLES {
        String UKIMWI_CONFIRMATION = "ec_ukimwi_confirmation";
        String UKIMWI_FOLLOW_UP = "ec_ukimwi_follow_up_visit";
    }

    interface ACTIVITY_PAYLOAD {
        String BASE_ENTITY_ID = "BASE_ENTITY_ID";
        String FAMILY_BASE_ENTITY_ID = "FAMILY_BASE_ENTITY_ID";
        String ACTION = "ACTION";
        String UKIMWI_FORM_NAME = "UKIMWI_FORM_NAME";

    }

    interface ACTIVITY_PAYLOAD_TYPE {
        String REGISTRATION = "REGISTRATION";
        String FOLLOW_UP_VISIT = "FOLLOW_UP_VISIT";
    }

    interface CONFIGURATION {
        String UKIMWI_CONFIRMATION = "ukimwi_confirmation";
    }

    interface UKIMWI_MEMBER_OBJECT {
        String MEMBER_OBJECT = "memberObject";
    }

}