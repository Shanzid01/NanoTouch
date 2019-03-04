package com.slideme.sam.manager;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: SAM */
class C1778e extends AsyncHttpResponseHandler {
    final /* synthetic */ SAM f3166a;

    C1778e(SAM sam) {
        this.f3166a = sam;
    }

    public void onFailure(Throwable th, String str) {
        C1922m.m5790a(new Exception(str, th));
    }
}
