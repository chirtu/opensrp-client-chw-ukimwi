package org.smartregister.chw.ukimwi.listener;


import android.view.View;

import org.smartregister.chw.ukimwi.fragment.BaseUkimwiCallDialogFragment;
import org.smartregister.chw.ukimwi.util.UkimwiUtil;
import org.smartregister.ukimwi.R;

import timber.log.Timber;

public class BaseUkimwiCallWidgetDialogListener implements View.OnClickListener {

    private BaseUkimwiCallDialogFragment callDialogFragment;

    public BaseUkimwiCallWidgetDialogListener(BaseUkimwiCallDialogFragment dialogFragment) {
        callDialogFragment = dialogFragment;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.ukimwi_call_close) {
            callDialogFragment.dismiss();
        } else if (i == R.id.ukimwi_call_head_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                UkimwiUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        } else if (i == R.id.call_ukimwi_client_phone) {
            try {
                String phoneNumber = (String) v.getTag();
                UkimwiUtil.launchDialer(callDialogFragment.getActivity(), callDialogFragment, phoneNumber);
                callDialogFragment.dismiss();
            } catch (Exception e) {
                Timber.e(e);
            }
        }
    }
}
