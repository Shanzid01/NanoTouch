package com.slideme.sam.manager.controller.activities;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.AppEventsConstants;
import com.slideme.sam.manager.controller.p053a.ah;
import com.slideme.sam.manager.net.C1881n;

/* compiled from: AboutActivity */
class C1636a implements OnClickListener {
    final /* synthetic */ AboutActivity f2740a;

    C1636a(AboutActivity aboutActivity) {
        this.f2740a = aboutActivity;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.slideme.sam.manager.extra.SUPPORT_RECEPIENT", C1881n.DEVELOPER.ordinal());
        bundle.putString("com.slideme.sam.manager.EXTRA_BUNDLE_ID", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        ah ahVar = new ah();
        ahVar.setArguments(bundle);
        ahVar.show(this.f2740a.getSupportFragmentManager(), "support_app");
    }
}
