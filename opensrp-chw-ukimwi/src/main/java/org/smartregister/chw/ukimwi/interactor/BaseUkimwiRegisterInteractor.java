package org.smartregister.chw.ukimwi.interactor;

import android.support.annotation.VisibleForTesting;

import org.smartregister.chw.ukimwi.contract.UkimwiRegisterContract;
import org.smartregister.chw.ukimwi.util.AppExecutors;
import org.smartregister.chw.ukimwi.util.UkimwiUtil;

public class BaseUkimwiRegisterInteractor implements UkimwiRegisterContract.Interactor {

    private AppExecutors appExecutors;

    @VisibleForTesting
    BaseUkimwiRegisterInteractor(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
    }

    public BaseUkimwiRegisterInteractor() {
        this(new AppExecutors());
    }

    @Override
    public void saveRegistration(final String jsonString, final UkimwiRegisterContract.InteractorCallBack callBack) {

        Runnable runnable = () -> {
            try {
                UkimwiUtil.saveFormEvent(jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            }

            appExecutors.mainThread().execute(() -> callBack.onRegistrationSaved());
        };
        appExecutors.diskIO().execute(runnable);
    }
}
