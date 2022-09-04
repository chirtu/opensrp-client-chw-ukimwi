package org.smartregister.chw.ukimwi.contract;

import android.content.Context;

public interface BaseUkimwiCallDialogContract {

    interface View {
        void setPendingCallRequest(Dialer dialer);
        Context getCurrentContext();
    }

    interface Dialer {
        void callMe();
    }
}
