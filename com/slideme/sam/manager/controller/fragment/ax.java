package com.slideme.sam.manager.controller.fragment;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.controller.activities.market.userinfo.MyAppsActivity;

/* compiled from: MyAccountFragment */
class ax implements OnClickListener {
    final /* synthetic */ aq f3066a;

    ax(aq aqVar) {
        this.f3066a = aqVar;
    }

    public void onClick(View view) {
        this.f3066a.startActivity(new Intent(this.f3066a.getActivity(), MyAppsActivity.class));
    }
}
