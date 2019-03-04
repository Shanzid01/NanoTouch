package com.slideme.sam.manager.net;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.util.C1922m;

/* compiled from: NetworkUtils */
class C1873f extends AsyncHttpResponseHandler {
    final /* synthetic */ C1867a f3400a;
    private final /* synthetic */ C1782r f3401b;

    C1873f(C1867a c1867a, C1782r c1782r) {
        this.f3400a = c1867a;
        this.f3401b = c1782r;
    }

    public void onSuccess(String str) {
        this.f3401b.onFinish(str);
    }

    public void onFailure(Throwable th, String str) {
        C1922m.m5791a(th);
        this.f3401b.onFinish("");
    }
}
