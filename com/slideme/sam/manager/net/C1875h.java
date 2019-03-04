package com.slideme.sam.manager.net;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.slideme.sam.manager.net.response.BaseNetworkResponse;

/* compiled from: NetworkUtils */
class C1875h extends AsyncHttpResponseHandler {
    final /* synthetic */ C1867a f3403a;
    private final /* synthetic */ Class f3404b;
    private final /* synthetic */ C1599q f3405c;

    C1875h(C1867a c1867a, Class cls, C1599q c1599q) {
        this.f3403a = c1867a;
        this.f3404b = cls;
        this.f3405c = c1599q;
    }

    public void onSuccess(String str) {
        BaseNetworkResponse a = this.f3403a.m5585b(str, this.f3404b);
        if (this.f3404b.getName().equals(Void.class.getName()) || a != null) {
            this.f3405c.mo4232a(a);
        } else {
            onFailure(new Exception(new StringBuilder(String.valueOf(this.f3404b.getName())).append(" parsing failed!").toString()), str);
        }
    }

    public void onFailure(Throwable th, String str) {
        this.f3403a.m5582a(th, str);
        this.f3405c.mo4233a(th, str);
    }

    public void onFinish() {
        this.f3405c.mo4231a();
    }

    public void onStart() {
        this.f3405c.mo4234b();
    }
}
