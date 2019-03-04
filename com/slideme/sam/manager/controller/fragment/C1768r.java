package com.slideme.sam.manager.controller.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.auth.AuthData;

/* compiled from: ApplicationDetailsFragment */
class C1768r implements OnClickListener {
    final /* synthetic */ C1767q f3148a;
    private final /* synthetic */ String f3149b;
    private final /* synthetic */ Dialog f3150c;

    C1768r(C1767q c1767q, String str, Dialog dialog) {
        this.f3148a = c1767q;
        this.f3149b = str;
        this.f3150c = dialog;
    }

    public void onClick(View view) {
        SAM.f2614g.m5624a(this.f3149b, AuthData.m4810f(this.f3148a.f3146a.getActivity()), new C1769s(this, this.f3150c));
    }
}
