package com.slideme.sam.manager;

import android.content.Intent;
import android.support.v4.content.C0090q;
import com.slideme.sam.manager.net.C1600v;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;
import com.slideme.sam.manager.net.response.DailyServiceResponse;

/* compiled from: SAM */
class C1906o extends C1600v {
    final /* synthetic */ SAM f3490a;

    C1906o(SAM sam) {
        this.f3490a = sam;
    }

    public void mo4232a(BaseNetworkResponse baseNetworkResponse) {
        SAM.f2619l.m5425a((DailyServiceResponse) baseNetworkResponse);
        C0090q.m145a(this.f3490a).m150a(new Intent("com.slideme.sam.manager.ACTION_DAILY_UPDATED"));
    }
}
