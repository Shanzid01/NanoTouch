package com.slideme.sam.manager.controller.p053a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.slideme.sam.manager.SAM;
import com.slideme.sam.manager.net.C1600v;

/* compiled from: ReviewRateDialog */
class aa implements OnClickListener {
    final /* synthetic */ C1635z f2673a;

    aa(C1635z c1635z) {
        this.f2673a = c1635z;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        SAM.f2614g.m5612a(this.f2673a.f2732a, new C1600v());
        this.f2673a.dismiss();
    }
}
