package org.smartregister.chw.ukimwi.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.ukimwi.contract.UkimwiProfileContract;
import org.smartregister.chw.ukimwi.domain.MemberObject;
import org.smartregister.chw.ukimwi.util.AppExecutors;
import org.smartregister.chw.ukimwi.util.UkimwiUtil;
import org.smartregister.domain.AlertStatus;

import java.util.Date;

public class BaseUkimwiProfileInteractor implements UkimwiProfileContract.Interactor {
    protected AppExecutors appExecutors;

    @VisibleForTesting
    BaseUkimwiProfileInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseUkimwiProfileInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void refreshProfileInfo(MemberObject memberObject, UkimwiProfileContract.InteractorCallBack callback) {
        Runnable runnable = () -> appExecutors.mainThread().execute(() -> {
            callback.refreshFamilyStatus(AlertStatus.normal);
            callback.refreshMedicalHistory(true);
            callback.refreshUpComingServicesStatus("Ukimwi Visit", AlertStatus.normal, new Date());
        });
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveRegistration(final String jsonString, final UkimwiProfileContract.InteractorCallBack callback) {

        Runnable runnable = () -> {
            try {
                UkimwiUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
        appExecutors.diskIO().execute(runnable);
    }
}
