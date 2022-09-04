package org.smartregister.chw.ukimwi.custom_views;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.LinearLayout;

import org.smartregister.chw.ukimwi.domain.MemberObject;
import org.smartregister.chw.ukimwi.fragment.BaseUkimwiCallDialogFragment;
import org.smartregister.ukimwi.R;

public class BaseUkimwiFloatingMenu extends LinearLayout implements View.OnClickListener {
    private MemberObject MEMBER_OBJECT;

    public BaseUkimwiFloatingMenu(Context context, MemberObject MEMBER_OBJECT) {
        super(context);
        initUi();
        this.MEMBER_OBJECT = MEMBER_OBJECT;
    }

    protected void initUi() {
        inflate(getContext(), R.layout.view_ukimwi_floating_menu, this);
        FloatingActionButton fab = findViewById(R.id.ukimwi_fab);
        if (fab != null)
            fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.ukimwi_fab) {
            Activity activity = (Activity) getContext();
            BaseUkimwiCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }  else if (view.getId() == R.id.refer_to_facility_layout) {
            Activity activity = (Activity) getContext();
            BaseUkimwiCallDialogFragment.launchDialog(activity, MEMBER_OBJECT);
        }
    }
}